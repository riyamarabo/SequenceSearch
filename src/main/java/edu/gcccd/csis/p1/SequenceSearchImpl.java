package edu.gcccd.csis.p1;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }


    @Override
    public String[] getAllTaggedSequences()
    {
        String [] taggedSequences = null;

        int iStart = 0;
        int iEnd;

       do {
            iStart = content.indexOf(startTag, iStart);
            iEnd = content.indexOf(endTag, iStart + startTag.length());

            String subString;
            if (iStart != -1)
            {
                subString = content.substring(iStart + startTag.length(), iEnd);
                taggedSequences = SequenceSearch.adds(taggedSequences, subString);
                iStart = iEnd + endTag.length();
            }

        }while(iStart != -1);

        return taggedSequences;
       }


    @Override
    public String getLongestTaggedSequence()
    {
        String[] taggedSequences = getAllTaggedSequences();

            int indexValue = 0;
            int element = taggedSequences[0].length();
            for (int i = 0; i < taggedSequences.length; i++)
            {
                if (taggedSequences[i].length() >= element)
                {
                    indexValue = i;
                    element = taggedSequences[i].length();
                }
            }   return taggedSequences[indexValue];
        }


    @Override
    public String displayStringArray()
    {
        String [] taggedSequences = getAllTaggedSequences();
        String printOneString;
        String printFinalString = null;

        for (int i = 0; i<taggedSequences.length; i++)
        {
         printOneString = taggedSequences[i] + " : " + taggedSequences[i].length() + "\n";
         if (printFinalString == null) {
             printFinalString = printOneString;
         }
         printFinalString = printFinalString + printOneString;
        }
            return printFinalString;
    }

    @Override
    public String toString()
    {

        String replaceStart = content.replace(startTag, "");
        String  replaceEnd = replaceStart.replace(endTag, "");
        return replaceEnd;
    }

}