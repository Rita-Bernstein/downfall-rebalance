package champ.cards;

import champ.ChampMod;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.stances.NeutralStance;

public class Taunt extends AbstractChampCard {

    public final static String ID = makeID("Taunt");

    //stupid intellij stuff ATTACK, ENEMY, STARTER

    public Taunt() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.ENEMY);
        tags.add(ChampMod.TECHNIQUE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        techique();
        if (upgraded) {
            for (AbstractMonster q : monsterList()) {
                applyToEnemy(q, autoWeak(q, 2));
            }
        } else {
            applyToEnemy(m, autoWeak(m, 2));
        }
        if (AbstractDungeon.player.stance.ID.equals(NeutralStance.STANCE_ID)) {
            int x = AbstractDungeon.cardRandomRng.random(2);
            switch (x) {
                case 0:
                    berserkerStance();
                    break;
                case 1:
                    gladiatorStance();
                    break;
                case 2:
                    defensiveStance();
                    break;
            }
        }
    }

    public void upp() {
        target = CardTarget.ALL_ENEMY;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}