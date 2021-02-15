public class Task2 {
    public static void main(String[] args) {

        PhoneBook pb = new PhoneBook();

        pb.add("Бигль", "123456");
        pb.add("Бигль", "654321");
        pb.add("Боксер>", "456862");
        pb.add("Чихуахуа", "789546");
        pb.add("Корги", "125689");
        pb.add("Мопс", "858762");
        pb.add("Дворняжка", "689489");
        pb.add("Мопс", "123456");


        System.out.println(pb.get("Бигль"));
        System.out.println(pb.get("Мопс"));
        System.out.println(pb.get("Корги"));
        System.out.println(pb.get("Уиппет"));


    }
}
