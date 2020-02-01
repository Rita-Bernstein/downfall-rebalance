package expansioncontent.powers;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import expansioncontent.expansionContentMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimebound.SlimeboundMod;
import theHexaghost.util.TextureLoader;


public class AwakenedOnePower extends AbstractPower {
    public static final String POWER_ID = expansionContentMod.makeID("AwakenedOnePower");

    private static final Texture tex84 = TextureLoader.getTexture(expansionContentMod.getModID() + "Resources/images/powers/darkRitual84.png");
    private static final Texture tex32 = TextureLoader.getTexture(expansionContentMod.getModID() + "Resources/images/powers/darkRitual32.png");

    private AbstractMonster sourceM;


    public AwakenedOnePower(AbstractCreature owner, AbstractCreature source, int amount) {


        this.name = "Dark Ritual";
        this.ID = POWER_ID;
        this.owner = AbstractDungeon.player;
        this.amount = amount;
        this.type = PowerType.DEBUFF;
        this.isTurnBased = true;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        this.updateDescription();

        sourceM = (AbstractMonster) owner;
    }


    
    public void atStartOfTurn() {
        if (this.sourceM.intent == AbstractMonster.Intent.ATTACK || this.sourceM.intent == AbstractMonster.Intent.ATTACK_BUFF || this.sourceM.intent == AbstractMonster.Intent.ATTACK_DEBUFF || this.sourceM.intent == AbstractMonster.Intent.ATTACK_DEFEND){

        } else
        {
            AbstractCreature p = AbstractDungeon.player;
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StrengthPower(p, this.amount), this.amount));
            AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, AwakenedOnePower.POWER_ID));


        }

        }

    @Override
    public void updateDescription() {
        description = "When you would die, heal " + amount + " HP and remove this effect.";
    }


}




