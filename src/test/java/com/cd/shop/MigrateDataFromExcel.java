package com.cd.shop;

import com.cd.shop.dataintegration.ExcelProduct;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static org.apache.poi.ss.usermodel.CellType.BLANK;


class MigrateDataFromExcel {
    private List<ExcelProduct> catalogue = new ArrayList<>();
    private String lastKnownCat1Lvl = null;
    private String lastKnownCat2Lvl = null;

    @Test
    void contextLoads() throws IOException {
        // Excel file link: https://freefly19.ams3.digitaloceanspaces.com/kupec/24.05.20_%D1%80%D0%BE%D0%B7%D0%BD_%D0%BE%D0%BF%D1%82.xlsx
        FileInputStream fileInputStream = new FileInputStream("24.05.20_розн_опт.xlsx");
        XSSFWorkbook priceBook = new XSSFWorkbook(fileInputStream);

        XSSFSheet mainSheet = priceBook.getSheetAt(0);

        for (int i = 0; i < mainSheet.getPhysicalNumberOfRows(); i++) {
            String name = mainSheet.getRow(i).getCell(0).toString();
            var type = CellType.byId(mainSheet.getRow(i).getCell(2).getCellStyle().getIndex());
            if (type.isPresent()) {
                switch (type.get()) {
                    case CATEGORY_1_LVL:
                        lastKnownCat1Lvl = name;
                        break;
                    case CATEGORY_2_LVL:
                        lastKnownCat2Lvl = name;
                        break;
                    case ITEM:
                        ExcelProduct excelProduct = new ExcelProduct();
                        excelProduct.setCategory1(lastKnownCat1Lvl);
                        excelProduct.setCategory2(lastKnownCat2Lvl);
                        excelProduct.setName(name);
                        excelProduct.setProductCode((long)mainSheet.getRow(i).getCell(2).getNumericCellValue());
                        if (!mainSheet.getRow(i).getCell(3).getCellType().equals(BLANK)) {
                            excelProduct.setPriceUsd(new BigDecimal(mainSheet.getRow(i).getCell(3).toString()));
                        }
                        if (!mainSheet.getRow(i).getCell(4).getCellType().equals(BLANK)) {
                            excelProduct.setPriceUah(new BigDecimal(mainSheet.getRow(i).getCell(4).toString()));
                        }
                        catalogue.add(excelProduct);
                        break;
                }
            }
        }

        catalogue.forEach(System.out::println);
    }

}

enum CellType {
    CATEGORY_1_LVL(8), CATEGORY_2_LVL(17), ITEM(12);

    private short id;

    CellType(int id) {
        this.id = (short) id;
    }

    public static Optional<CellType> byId(short id) {
        return Arrays.stream(CellType.values())
                .filter(el -> el.id == id)
                .findAny();
    }
}