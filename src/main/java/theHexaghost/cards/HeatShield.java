package theHexaghost.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theHexaghost.powers.BurnPower;

public class HeatShield extends AbstractHexaCard {

    public final static String ID = makeID("HeatShield");

    //stupid intellij stuff SKILL, SELF_AND_ENEMY, UNCOMMON

    public HeatShield() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 5;
    }

    @Override
    protected void applyPowersToBlock() {
        int realBaseBlock = this.baseBlock;
        super.applyPowersToBlock();
        this.magicNumber = this.baseMagicNumber = this.block;
        for (AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            if (mo.hasPower(BurnPower.POWER_ID))
                baseBlock += mo.getPower(BurnPower.POWER_ID).amount;
        }
        super.applyPowersToBlock();
        this.baseBlock = realBaseBlock;// 75
        this.isBlockModified = block != baseBlock;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(3);
        }
    }
}