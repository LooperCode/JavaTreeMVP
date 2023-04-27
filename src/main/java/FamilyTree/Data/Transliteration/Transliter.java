package FamilyTree.Data.Transliteration;

public class Transliter {
    public static String cyr2lat(char ch) {
        switch (ch) {
            case 'А':
                return "A";
            case 'Б':
                return "B";
            case 'В':
                return "V";
            case 'Г':
                return "G";
            case 'Д':
                return "D";
            case 'Е':
                return "E";
            case 'Ё':
                return "JE";
            case 'Ж':
                return "ZH";
            case 'З':
                return "Z";
            case 'И':
                return "I";
            case 'Й':
                return "Y";
            case 'К':
                return "K";
            case 'Л':
                return "L";
            case 'М':
                return "M";
            case 'Н':
                return "N";
            case 'О':
                return "O";
            case 'П':
                return "P";
            case 'Р':
                return "R";
            case 'С':
                return "S";
            case 'Т':
                return "T";
            case 'У':
                return "U";
            case 'Ф':
                return "F";
            case 'Х':
                return "KH";
            case 'Ц':
                return "C";
            case 'Ч':
                return "CH";
            case 'Ш':
                return "SH";
            case 'Щ':
                return "JSH";
            case 'Ъ':
                return "HH";
            case 'Ы':
                return "IH";
            case 'Ь':
                return "JH";
            case 'Э':
                return "EH";
            case 'Ю':
                return "JU";
            case 'Я':
                return "JA";
            default:
                return String.valueOf(ch);
        }
    }

    public static String cyr2lat(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 2);
        for (char ch : s.toCharArray()) {
            sb.append(cyr2lat(ch));
        }
        return sb.toString();
    }


    public static String lat2cyr(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == 'J') {
                i++;
                ch = s.charAt(i);
                switch (ch) {
                    case 'E':
                        sb.append('Ё');
                        break;
                    case 'S':
                        sb.append('Щ');
                        i++;
                        if (s.charAt(i) != 'H')
                            throw new IllegalArgumentException("Illegal transliterated symbol at position " + i);
                        break;
                    case 'H':
                        sb.append('Ь');
                        break;
                    case 'U':
                        sb.append('Ю');
                        break;
                    case 'A':
                        sb.append('Я');
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal transliterated symbol at position " + i);
                }
            } else if (i + 1 < s.length() && s.charAt(i + 1) == 'H' && !(i + 2 < s.length() && s.charAt(i + 2) == 'H')) {
                switch (ch) {
                    case 'Z':
                        sb.append('Ж');
                        break;
                    case 'K':
                        sb.append('Х');
                        break;
                    case 'C':
                        sb.append('Ч');
                        break;
                    case 'S':
                        sb.append('Ш');
                        break;
                    case 'E':
                        sb.append('Э');
                        break;
                    case 'H':
                        sb.append('Ъ');
                        break;
                    case 'I':
                        sb.append('Ы');
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal transliterated symbol at position " + i);
                }
                i++;
            } else {
                switch (ch) {
                    case 'A':
                        sb.append('А');
                        break;
                    case 'B':
                        sb.append('Б');
                        break;
                    case 'V':
                        sb.append('В');
                        break;
                    case 'G':
                        sb.append('Г');
                        break;
                    case 'D':
                        sb.append('Д');
                        break;
                    case 'E':
                        sb.append('Е');
                        break;
                    case 'Z':
                        sb.append('З');
                        break;
                    case 'I':
                        sb.append('И');
                        break;
                    case 'Y':
                        sb.append('Й');
                        break;
                    case 'K':
                        sb.append('К');
                        break;
                    case 'L':
                        sb.append('Л');
                        break;
                    case 'M':
                        sb.append('М');
                        break;
                    case 'N':
                        sb.append('Н');
                        break;
                    case 'O':
                        sb.append('О');
                        break;
                    case 'P':
                        sb.append('П');
                        break;
                    case 'R':
                        sb.append('Р');
                        break;
                    case 'S':
                        sb.append('С');
                        break;
                    case 'T':
                        sb.append('Т');
                        break;
                    case 'U':
                        sb.append('У');
                        break;
                    case 'F':
                        sb.append('Ф');
                        break;
                    case 'C':
                        sb.append('Ц');
                        break;
                    default:
                        sb.append(ch);
                }
            }
            i++;
        }
        return sb.toString();
    }
}

