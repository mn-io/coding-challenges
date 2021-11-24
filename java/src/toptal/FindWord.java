package toptal;

import java.util.*;

public class FindWord {
    public static void main(String[] args) {
        String s = findWord(new String[]{"P>E", "E>R", "R>U"});
        if (!Objects.equals(s, "PERU")) throw new AssertionError();

        s = findWord(new String[]{"I>N", "A>I", "P>A", "S>P"});
        if (!Objects.equals(s, "SPAIN")) throw new AssertionError();

        s = findWord(new String[]{"U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"});
        if (!Objects.equals(s, "HUNGARY")) throw new AssertionError();

        s = findWord(new String[]{"I>F", "W>I", "S>W", "F>T"});
        if (!Objects.equals(s, "SWIFT")) throw new AssertionError();

        s = findWord(new String[]{"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"});
        if (!Objects.equals(s, "PORTUGAL")) throw new AssertionError();

        s = findWord(new String[]{"W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"});
        if (!Objects.equals(s, "SWITZERLAND")) throw new AssertionError();
    }

    private static String findWord(String[] precs) {
        System.out.print(Arrays.toString(precs) + " -> ");

        LinkedList<String> resultList = new LinkedList<>();
        final List<String> precList = new ArrayList<>(Arrays.asList(precs));
        resultList.add(precList.get(0));
        precList.remove(0);

        while (!precList.isEmpty()) {
            String precToBeRemoved = null;
            for (String prec : precList) {
                int insertPosition = findInsertPosition(resultList, prec);
                if (insertPosition >= 0) {
                    resultList.add(insertPosition, prec);
                    precToBeRemoved = prec;
                    break;
                }
            }

            if (precToBeRemoved == null) {
                throw new IllegalStateException("should not happen");
            }
            precList.remove(precToBeRemoved);
        }

        final StringBuilder sb = new StringBuilder();
        for (String s : resultList) {
            sb.append(s.charAt(0));
        }
        sb.append(resultList.getLast().charAt(2));

        System.out.println(sb);
        return sb.toString();
    }

    private static int findInsertPosition(LinkedList<String> resultList, String prec) {
        int insertPosition = -1;
        int i = 0;
        for (String existingS : resultList) {
            final boolean endsWith = existingS.endsWith(prec.charAt(0) + "");
            if (endsWith) {
                insertPosition = i + 1;
                break;
            }

            final boolean startsWith = existingS.startsWith(prec.charAt(2) + "");
            if (startsWith) {
                insertPosition = i;
                break;
            }
            i++;
        }
        return insertPosition;
    }

    private static String findWord1(String[] prec) {
        LinkedList<String> list = new LinkedList<>();

        for (String p : prec) {
            final String startC = p.charAt(0) + "";
            final String endC = p.charAt(2) + "";
            final String newS = startC + endC;
            if (list.isEmpty()) {
                list.add(newS);
            } else {
                int insertPosition = -1;
                for (int i = 0; i < list.size(); i++) {
                    String existingS = list.get(i); // expensive

                    final boolean endsWith = existingS.endsWith(startC);
                    if (endsWith) {
                        insertPosition = i + 1;
                        break;
                    }

                    final boolean startsWith = existingS.startsWith(endC);
                    if (startsWith) {
                        insertPosition = i;
                        break;
                    }
                }

                if (insertPosition < 0) {
                    throw new IllegalStateException("should not happen");
                }
                list.add(insertPosition, newS);
            }
        }


        final StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s.charAt(0));
        }
        sb.append(list.getLast().charAt(1));

        return sb.toString();
    }
}
