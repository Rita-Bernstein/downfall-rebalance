package theHexaghost.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theHexaghost.GhostflameHelper;
import theHexaghost.HexaMod;
import theHexaghost.ghostflames.AbstractGhostflame;
import theHexaghost.ghostflames.BolsteringGhostflame;
import theHexaghost.ghostflames.MayhemGhostflame;
import theHexaghost.util.TextureLoader;

import static theHexaghost.HexaMod.makeRelicOutlinePath;
import static theHexaghost.HexaMod.makeRelicPath;

public class SoulOfChaos extends CustomRelic {

    public static final String ID = HexaMod.makeID("SoulOfChaos");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("SpiritBrand.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("SpiritBrand.png"));

    public SoulOfChaos() {
        super(ID, IMG, OUTLINE, RelicTier.RARE, LandingSound.MAGICAL);
    }

    @Override
    public void atBattleStart() {
        flash();
        AbstractGhostflame q = GhostflameHelper.hexaGhostFlames.get(2);
        AbstractGhostflame gf = new MayhemGhostflame(q.lx, q.ly);
        GhostflameHelper.hexaGhostFlames.set(2, gf);
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}