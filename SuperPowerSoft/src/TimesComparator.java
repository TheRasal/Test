import java.util.Comparator;

public class TimesComparator implements Comparator<Shedule> {

   @Override
   public int compare(Shedule o1, Shedule o2) {
      if (o1.getStartTime().equals(o2.getStartTime())) {
         return o1.getEndTime().compareTo(o2.getEndTime());

      }
      return o1.getStartTime().compareTo(o2.getStartTime());
   }
}
