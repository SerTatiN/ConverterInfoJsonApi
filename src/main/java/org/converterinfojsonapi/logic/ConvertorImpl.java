package org.converterinfojsonapi.logic;

import org.converterinfojsonapi.service.ClassMessage;
import java.util.Arrays;
import java.util.List;
/* Онлайн конвертер единиц информации (байт, кб, мб, гб).

Приставки для двоичных множителей обозначаются как Ки (Ki), Ми (Mi), Ги (Gi)/
ГОСТ Р МЭК 80000-13-2016 Государственная система обеспечения единства измерений (ГСИ).
Величины и единицы. Часть 13. Информатика и информационные технологии.
*/

public class ConvertorImpl implements IConverter {
    private final List<String> bL = Arrays.asList("b", "б", "byte", "байт");
    private final List<String> kL = Arrays.asList("кб", "киби", "kb", "kibi", "ки", "ki");
    private final List<String> mL = Arrays.asList("мб", "меби", "mb", "mebi", "ми", "mi");
    private final List<String> gL = Arrays.asList("гб", "гиби", "gb", "gibi", "ги", "gi");
    private final List<String>[] mass = new List[]{bL, kL, mL, gL};

    private final int[] koefV = {1, 1024, 1048576, 1073741824};

    @Override
    public ClassMessage.OutputMessage convertor(ClassMessage.InputMessage inputMessage) {

        String from = inputMessage.getFrom();
        String to = inputMessage.getTo();
        double value = inputMessage.getValue();

        int i = getIndex(from);
        int j = getIndex(to);

        if (i < 0 || j < 0 || value < 0) {
            return null;
        } else {
            return new ClassMessage.OutputMessage(from, to, value * koefV[i] / koefV[j]);
        }
    }
        private int getIndex (String s){
            for (int i = 0; i < mass.length; i++) {
                if (mass[i].indexOf(s.toLowerCase()) >= 0) {
                    return i;
                }
            }
            return -1;
        }
}
