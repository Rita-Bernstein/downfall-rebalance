package champ.cards;

import champ.powers.WorseRupturePower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class EndlessRage extends AbstractChampCard {

    public final static String ID = makeID("EndlessRage");

    //stupid intellij stuff power, self, uncommon

    public EndlessRage() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new WorseRupturePower(1));
    }

    public void upp() {
        isInnate = true;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}