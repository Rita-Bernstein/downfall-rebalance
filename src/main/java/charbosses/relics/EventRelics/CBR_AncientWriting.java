package charbosses.relics.EventRelics;

import charbosses.cards.AbstractBossCard;
import charbosses.relics.AbstractCharbossRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import downfall.downfallMod;

import java.util.ArrayList;


public class CBR_AncientWriting extends AbstractCharbossRelic {
    public static String ID = downfallMod.makeID("AncientWriting");
    private static RelicTier tier = RelicTier.SPECIAL;
    private static LandingSound sound = LandingSound.MAGICAL;
    private int count;

    public CBR_AncientWriting() {
        super(ID, tier, sound, new Texture(downfallMod.assetPath("images/relics/backtobasics.png")));
        this.largeImg = null;
    }

    @Override
    public void modifyCardsOnCollect(ArrayList<AbstractBossCard> list, int actIndex) {
        for (AbstractBossCard c : list){
            if (!c.upgraded && (c.hasTag(AbstractCard.CardTags.STARTER_STRIKE) || c.hasTag(AbstractCard.CardTags.STARTER_DEFEND)));
            c.upgrade();
            count++;
        }


        this.description = getUpdatedDescription();
        refreshDescription();

    }

    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new CBR_AncientWriting();
    }
}
