package company;

import java.util.*;

public class Test {

    private String[] text;
    private int widthColumn;
    private List<String> listOfRows;
    private int numColumns;
    private ArrayList[] tabAsColumn;
    private List<String> tempListOfRows;


    public Test(String text, int numColumns, int widthColumn) {
        this.text = processText(text);
        this.widthColumn = widthColumn;
        this.numColumns = numColumns;
    }

    String[] processText(String text) {
        return text.trim().split(" +");
    }

    int checkTheLongestWord() {
        int longestWord = 0;
        for (String word : text) {
            if (word.length() > longestWord) {
                longestWord = word.length();
            }
        }

        if (longestWord > widthColumn) {
            System.out.println("Change width of column due of length the longest word in the text: " + longestWord + "!");
            System.out.println();
            widthColumn = longestWord;
        }
        return widthColumn;
    }

    List<String> buildRows() {

        checkTheLongestWord();

        listOfRows = new ArrayList<>();

        String row = text[0];

        for (int nextWordIndex = 1; nextWordIndex < text.length + 1; nextWordIndex++) {
            if (nextWordIndex < text.length) {
                if (row.length() < widthColumn && (row.length() + text[nextWordIndex].length()) < widthColumn) {
                    //przenoszenie pojedynczych liter na początek linii
                    if (text[nextWordIndex].length() == 1 && (row.length() + text[nextWordIndex].length() + text[nextWordIndex + 1].length()) >= widthColumn - 1) {
                        listOfRows.add(row);
                        row = text[nextWordIndex];

                    } else {
                        row += " " + text[nextWordIndex];
                    }

                } else if (row.length() < widthColumn && (row.length() + text[nextWordIndex].length()) >= widthColumn) {
                    listOfRows.add(row);
                    row = text[nextWordIndex];

                } else if (row.length() == widthColumn) {
                    listOfRows.add(row);
                    row = text[nextWordIndex];

                } else if (text[nextWordIndex].length() == 1 && (row.length() + text[nextWordIndex].length()) >= widthColumn) {
                    listOfRows.add(row);
                    row = text[nextWordIndex];

                }
            } else {
                listOfRows.add(row);
                row = null;

            }
        }

        return listOfRows;
    }

    private void divideListToColumns() {
        buildRows();
        tabAsColumn = new ArrayList[numColumns];
        tempListOfRows = new ArrayList<>(listOfRows);
        int counter = numColumns;

        for (int i = 0; i < numColumns; i++) {
            tabAsColumn[i] = new ArrayList();

            if ((listOfRows.size() % numColumns) == 0) {
                while (tabAsColumn[i].size() < listOfRows.size() / numColumns) {
                    fillColumn(i);
                }
            }else {
                if (tempListOfRows.size() % counter != 0){
                    while (tabAsColumn[i].size() <= listOfRows.size() / numColumns
                            && !tempListOfRows.isEmpty()) {
                        fillColumn(i);
                    }
                }else {
                    while (tabAsColumn[i].size() < listOfRows.size() / numColumns) {
                        fillColumn(i);
                    }
                }
            }
            counter--;
            }
        }

    private void fillColumn(int i){
        tabAsColumn[i].add(tempListOfRows.get(0));
        tempListOfRows.remove(0);
    }

    public void printInConsole() {
        divideListToColumns();

        for (int j = 0; j < tabAsColumn[0].size(); j++){
            for(int i = 0; i < tabAsColumn.length; i++) {

                if (tabAsColumn[i].size() < tabAsColumn[0].size()
                        && j == tabAsColumn[i].size()){
                    System.exit(0);
                }else {
                    System.out.printf("%-" + (widthColumn + 2) + "s", tabAsColumn[i].get(j));
                }
            }
            System.out.println();
        }
    }

    public void setText (String[]text){
            this.text = text;
        }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    public void setWidthColumn(int widthColumn){
        this.widthColumn = widthColumn;
    }
}

