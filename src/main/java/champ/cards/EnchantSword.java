package champ.cards;

import champ.ChampMod;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class EnchantSword extends AbstractChampCard {

    public final static String ID = makeID("EnchantSword");

    //stupid intellij stuff skill, self, uncommon

    public EnchantSword() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        exhaust = true;
      //  tags.add(ChampMod.FINISHER);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (upgraded) techique();
        //finisher();
        applyToSelf(new StrengthPower(p, 2));
        if (bcombo()) exhaust = false;
      //  finisher();
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = (bcombo()) ? GOLD_BORDER_GLOW_COLOR : BLUE_BORDER_GLOW_COLOR;
    }

    public void upp() {
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
        tags.add(ChampMod.TECHNIQUE);
    }
}