package company;

public class Main {

    public static void main(String[] args) {

        // Przykładowy tekst
        String text = "Tutaj nie ma żadnego haczyka i nazwa dokładnie " +
                "wskazuje o czym mówimy. Immutable m object jest " +
                "to niezmienny obiekt, czyli taki, którego m stan nie " +
                "może zostać m zmieniony cały okres życia m obiektu. " +
                "Czyli po prostu tworzymy m " +
                "" +
                "" +
                "nasz obiekt wraz ze " +
                "wszystkimi m wymaganymi atrybutami i żadnego z nich nie " +
                "możemy m zmienić. Przynajmniej w teorii… ale zmiany " +
                "poprzez m refleksje się nie liczą, więc m uznajemy, " +
                "że nie mamy możliwości m zmiany wartości tych " +
                "atrybutów";


        Test test = new Test(text, 3, 20);
        test.printInConsole();
    }
}