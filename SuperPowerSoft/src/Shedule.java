public class Shedule {
   private String startTime;
  private String endTime;

    public Shedule(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Shedule{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}


//
//    Обычный свой класс который представляет, одну запись с текстового файла.
//        не полная проверка, if (date2.before(date1)&&date3.after(date)) надо проверять и наоборот
//        Юра
//        Юра 10:57
//        Если время начала до окончания работа и время окончания работы после начала работы
//        Вадим
//        Вадим 10:58
//        как бы я делал, это:
//        1) Считывал с файла и создавал List<Shedule>.
//        2) Отсортировал бы его с помощью Collection.sort(list,Comparator), где Comparator тоже кастомный который проверяет время начало, если равно то время конца.
//        3) шел бы от первого к последнему и проверял бы 1 item до того момента пока item[0].endTime > item[i].startTime и сохранял в аля массив, причем countEmployee[0]++ и countEmployee[i]++.
//        4) Вывел max из countEmployee
//        5) разбить грамотно на методы
//        6) в Unit тестах проверять только метод который выдает max, без работы с файла