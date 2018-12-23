package com.company.ooppa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Messages {

    private static List<String> messages = new ArrayList<>(
            Arrays.asList("Szeretlek!", "Nagyon szeretlek!", "Szépek a szemeid!", "Tetszik az alakod!", "Jó a feneked!",
                    "MMMmmm a hajad!", "Jók a lábaid!", "Tetszenek az érdeklődési köreid!", "Ügyesen tudsz hallgatni!",
                    "Nagyon tetszik a kommunikációs stílusod!", "Tetszik, ahogy a testvéreiddel bánsz!",
                    "Tetszik, ahogy otthon mozogsz!", "Tetszel a Shalomban!", "Szép a lelked!", "Örülök, hogy keresztény vagy!",
                    "Szeretlek megölelni!", "Jókat tudunk beszélgetni!", "Annyira örülök, hogy nem játszmázol!",
                    "Remekül bánsz velem a kapcsolatban!", "Szeretem az értékrended!", "Nagyon büszke vagyok az egyetemi teljesítményedre!",
                    "Oda vagyok az öltözködési stílusodért!", "Remekül ölelsz!", "Jó az illatod!", "Szívesen szereplek a jövőről alkotott elképzeléseidben!",
                    "Köszönöm, hogy támogatsz!", "Köszönöm, hogy velem vagy!", "Hálás vagyok a rengeteg figyelemért, amit tőled kapok!",
                    "Szerintem tökéletes a magasságod!",  "Tetszik a kereszténységed!", "Örülök a konformizmusodnak!",
                    "Tetszik, hogy bízhatok benned!",  "Tetszik az észjárásod!",  "Tetszenek a témák, amiket a beszélgetéseinkbe hozol!",
                    "Szeretem az éneked!", "Szeretem a hegedűjátékod!", "Jól áll a lovaglás!", "Szeretem a combodra hajtani a fejem!",
                    "Jó nézni, ahogy energiát fektetsz a barátságaidba!", "Hálás vagyok mindazért, amit a kapcsolatunkért teszel!",
                    "Szeretem a humorod!", "Újra és újra meglepődök a  figyelmességeden!", "Jó veled együtt lenni!",
                    "Köszönöm, hogy megértesz!", "A nevetésed gyógyít!", "A mosolyodért ölni tudnék (kisebb állatokat max)!",
                    "Olyan jó tudni, hogy találkozni fogunk!", "Hiányzol, amikor nem látlak!", "Jó érzés, hogy önmagam lehetek veled!",
                    "Jó meglátni téged!", "Otthonosan érzem magam veled!", "Köszönöm, hogy nyitott vagy rám!",
                    "Örülök, hogy kommunikálni kényszerítesz akkor is, amikor besértődnék!", "Tetszenek a képeid ;-)!",
                    "Jól mutatunk együtt!", "Tetszenek az orcáid!", "Hálásan gondolok vissza az együtt töltött időre!",
                    "Szeretem, ahogy hozzám bújsz!",  "Örülök, hogy egyre több dolgot meg tudunk osztani egymással!",
                    "Finom a csókod!", "Finom a hajad!", "Tudunk jó programokat kitalálni!", "Ügyes a konfliktus-kezelésed!",
                    "Tetszik, ahogy figyelsz az egészségedre!", "Hálás vagyok, hogy kitartasz mellettem!", "Jól áll a választott szakmád!",
                    "Tetszik, ahogy fogalmazol!", "Tetszik, hogy végiggondolod a dolgaid!"
            )
    );



    public static String getRandom() {
        Random random = new Random();
        return messages.get(random.nextInt(messages.size()));
    }
}
