package champ.stances;

import champ.ChampChar;
import champ.powers.CounterPower;
import champ.relics.DefensiveTrainingManual;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class DefensiveStance extends AbstractChampStance {

    public static final String STANCE_ID = "champ:DefensiveStance";
    private static long sfxId = -1L;

    public DefensiveStance() {
        this.ID = STANCE_ID;
        this.name = ChampChar.characterStrings.TEXT[4];
        this.updateDescription();
    }

    @Override
    public String getKeywordString() {
        return "champ:defensive";
    }

    @Override
    public void updateDescription() {
        this.description = ChampChar.characterStrings.TEXT[8] + ": " + ChampChar.characterStrings.TEXT[12] + " NL " + ChampChar.characterStrings.TEXT[9] + ": " + ChampChar.characterStrings.TEXT[13];
    }

    @Override
    public void technique() {
        if (AbstractDungeon.player.hasRelic(DefensiveTrainingManual.ID)){
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new CounterPower(9), 9));

        } else {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new CounterPower(6), 6));

        }
    }

    @Override
    public void finisher() {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(AbstractDungeon.player, 12));
    }
}
