package champ.cards;

import champ.ChampMod;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import downfall.actions.OctoChoiceAction;
import downfall.cards.OctoChoiceCard;
import downfall.util.OctopusCard;
import theHexaghost.HexaMod;

import java.util.ArrayList;

public class Balance extends AbstractChampCard implements OctopusCard {

    public final static String ID = makeID("Balance");

    //stupid intellij stuff skill, self, common

    public Balance() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        tags.add(ChampMod.OPENER);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new OctoChoiceAction(this));
    }

    public ArrayList<OctoChoiceCard> choiceList() {
        ArrayList<OctoChoiceCard> cardList = new ArrayList<>();
        cardList.add(new OctoChoiceCard("octo:OctoDefense", this.name, HexaMod.makeCardPath("Float.png"), upgraded ? this.EXTENDED_DESCRIPTION[2] : this.EXTENDED_DESCRIPTION[0]));
        cardList.add(new OctoChoiceCard("octo:OctoGladiat", this.name, HexaMod.makeCardPath("Float.png"), upgraded ? this.EXTENDED_DESCRIPTION[3] : this.EXTENDED_DESCRIPTION[1]));
        return cardList;
    }

    public void doChoiceStuff(OctoChoiceCard card) {
        switch (card.cardID) {
            case "octo:OctoDefense":
                defenseOpen();
                ArrayList<AbstractCard> qCardList = new ArrayList<AbstractCard>();
                for (AbstractCard t : CardLibrary.getAllCards()) {
                    if (t.rawDescription.contains("champ:Defensive champ:Combo")) qCardList.add(t);
                }
                AbstractCard q = qCardList.get(AbstractDungeon.cardRandomRng.random(qCardList.size() - 1));
                if (upgraded) q.upgrade();
                makeInHand(q);
                break;
            case "octo:OctoGladiat":
                gladOpen();
                ArrayList<AbstractCard> rCardList = new ArrayList<AbstractCard>();
                for (AbstractCard t : CardLibrary.getAllCards()) {
                    if (t.rawDescription.contains("champ:Gladiator champ:Combo")) rCardList.add(t);
                }
                AbstractCard r = rCardList.get(AbstractDungeon.cardRandomRng.random(rCardList.size() - 1));
                if (upgraded) r.upgrade();
                makeInHand(r);
                break;
        }
    }

    public void upp() {
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}