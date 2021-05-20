package pl.lublin.wsei.java.cwiczenia.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegEx {
    public static void main(String[] args){
        String exItem = "\t\t<item>\n" +
                "\t\t<title><![CDATA[Infografika - Walentynki-Dzień Zakochanych]]></title>\n" +
                "\t\t<pubDate><![CDATA[Fri, 12 Feb 2021 07:18:00 +0100]]></pubDate>\n" +
                "\t\t<link>https://stat.gov.pl/infografiki-widzety/infografiki/infografika-walentynki-dzien-zakochanych,98,1.html</link>\n" +
                "\t\t<guid isPermaLink=\"false\">https://stat.gov.pl/infografiki-widzety/infografiki/infografika-walentynki-dzien-zakochanych,98,1.html</guid>\n" +
                "\t\t<media:content url=\"https://stat.gov.pl/files/gfx/portalinformacyjny/pl/defaultaktualnosci/5866/98/1/1/walentynki_2021-01.png\" type=\"image/png\" width=\"1024\" height=\"1358\">\n" +
                "\t\t<media:description type=\"plain\"><![CDATA[]]></media:description>\n" +
                "\t\t<media:thumbnail url=\"https://stat.gov.pl//gfx/portalinformacyjny/_thumbs/pl/defaultaktualnosci/5866/98/1/1/walentynki_2021-01,k1uUwl-caFOE6tCTiHtf.png\" />\n" +
                "\t\t</media:content>\n" +
                "\t\tdescription><![CDATA[<div><img src=\"https://stat.gov.pl//gfx/portalinformacyjny/_thumbs/pl/defaultaktualnosci/5866/98/1/1/walentynki_2021-01,k1uUwl-caFOE6tCTiHtf.png\" alt=\"\" width=\"280\" height=\"212\"/></div>]]></description>\n" +
                "\t\t</item>";

        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher match = pat.matcher(exItem);
        if(match.find()){
            System.out.println("Tytuł: " + match.group(1));
        } else{
            System.out.println("Nie znaleziono tytułu...");
        }

        pat = Pattern.compile("<link>(.*)<\\/link>");
        match = pat.matcher(exItem);
        if(match.find()){
            System.out.println("Adres strony: " + match.group(1));
        } else{
            System.out.println("Nie znaleziono adresu strony...");
        }

        pat = Pattern.compile("url=\\\"(.*)\\\" type");
        match = pat.matcher(exItem);
        if(match.find()){
            System.out.println("Adres infografiki: " + match.group(1));
        } else{
            System.out.println("Nie znaleziono adresu infografiki...");
        }

        pat = Pattern.compile("url=\\\"(.*)\\\" \\/>");
        match = pat.matcher(exItem);
        if(match.find()){
            System.out.println("Adres miniaturki infografiki: " + match.group(1));
        } else{
            System.out.println("Nie znaleziono adresu miniaturki infografiki...");
        }

        pat = Pattern.compile("width=\\\"(.*)\\\" height");
        match = pat.matcher(exItem);
        if(match.find()){
            System.out.println("Szerokosc infografiki: " + match.group(1));
        } else{
            System.out.println("Nie znaleziono szerokosci infografiki...");
        }

        pat = Pattern.compile("height=\\\"(.*)\\\">");
        match = pat.matcher(exItem);
        if(match.find()){
            System.out.println("Wysokosc infografiki: " + match.group(1));
        } else{
            System.out.println("Nie znaleziono wysokosci infografiki...");
        }



    }
}