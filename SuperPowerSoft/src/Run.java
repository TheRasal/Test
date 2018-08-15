import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static sun.swing.MenuItemLayoutHelper.max;

public class Run {

    public static void main(String[] args) {

        Run run = new Run();
        System.out.println(run.maxEmployee(run.read("input.txt")));

    }

    private List<Shedule> read(String input) {
        List<Shedule> shedules = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(input));
            if (!regex(sc.nextLine())) {
                return null;
            }
                while (sc.hasNext()) {
                    String times[] = sc.nextLine().split(" ");
                    shedules.add(new Shedule(times[0], times[1]));
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(shedules, new TimesComparator());

return shedules;
    }



   public int maxEmployee(List<Shedule> shedules) {

            int counEmployee[] = new int[shedules.size()];
            int item = 0;
            int nextItem = 0;
            if (shedules.size() == 0) {
                return 0;
            }
            while (item + 1 < shedules.size()) {
                nextItem = item + 1;
                while ((shedules.get(item).getEndTime().compareTo(shedules.get(nextItem).getStartTime())) > 0) {
                    counEmployee[item]++;
                    counEmployee[nextItem]++;
                    nextItem++;
                }
                if (nextItem + 1 == shedules.size()) {
                    item = shedules.size();
                } else {
                    item++;
                }
            }
            return max(counEmployee) + 1;
        }

        private boolean regex (String s){

            final String regex = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]\\s([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
            final String string = s;

            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(string);

            return matcher.matches();
            }

        }





