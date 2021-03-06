package guardian.cards;


import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Slimed;
import com.megacrit.cardcrawl.cards.status.VoidCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import guardian.GuardianMod;
import slimebound.SlimeboundMod;
import slimebound.cards.AbstractSlimeboundCard;


public class Aged extends CustomCard {
    public static final String ID = GuardianMod.makeID("Aged");
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "cards/aged.png";
    private static final CardType TYPE = CardType.CURSE;
    private static final CardRarity RARITY = CardRarity.CURSE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardStrings cardStrings;
    private static final int COST = -2;
    public static String UPGRADED_DESCRIPTION;

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }

    public Aged() {
        super(ID, NAME, GuardianMod.getResourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, CardColor.CURSE, RARITY, TARGET);

        this.magicNumber = this.baseMagicNumber = 1;
        this.cardsToPreview = new VoidCard();

        this.isEthereal = true;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    @Override
    public void triggerOnEndOfTurnForPlayingCard() {
        super.triggerOnEndOfTurnForPlayingCard();
        this.flash();
        this.superFlash();
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new VoidCard(),1, false, false, false));

    }

    public AbstractCard makeCopy() {
        return new Aged();
    }

    public void upgrade() {
    }
}


