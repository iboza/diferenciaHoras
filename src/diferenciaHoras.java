import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class diferenciaHoras {


    public static void main(String[] args) {
        String fInicial = "20/09/21 10:50:00";
        String fFinal = "20/09/21 13:29:00";

//         Formato de fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy HH:mm:ss");


        Date f1 = null;
        Date f2 = null;
        try {
            f1 = formato.parse(fInicial);
            f2 = formato.parse(fFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//         Obtiene milisegundos para realizar la resta.
        assert f2 != null;
        long diff = f2.getTime() - f1.getTime();


        long dias = TimeUnit.MILLISECONDS.toDays(diff);
        long HorasEnMillis = diff - TimeUnit.DAYS.toMillis(dias);
        long horas = TimeUnit.MILLISECONDS.toHours(HorasEnMillis);
        long MinutosEnMillis = HorasEnMillis - TimeUnit.HOURS.toMillis(horas);
        long min = TimeUnit.MILLISECONDS.toMinutes(MinutosEnMillis);
        long SegundosEnMillis = MinutosEnMillis - TimeUnit.MINUTES.toMillis(min);
        long seg = TimeUnit.MILLISECONDS.toSeconds(SegundosEnMillis);

        if (dias < 1) {
            System.out.printf("%d Horas, %d Minutos, %d Segundos.", horas, min, seg);

        } else {
            System.out.printf("%d Dias, %d Horas, %d Minutos, %d Segundos.", dias, horas, min, seg);
        }
    }
}