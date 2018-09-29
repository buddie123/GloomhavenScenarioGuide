package robby35us.com.gloomhavenscenarioguide.models;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Scenario {

    public static final int TOTAL_NUM_SCENARIOS = 96;
    public static final int NUM_OF_FIRST_SIDE_QUEST = 52;
    private static String[] scenarioNames = new String[]{
            "0 Gloomhaven"
            ,"1 Black Barrow"
            ,"2 Barrow Lair"
            ,"3 Inox Encampment"
            ,"4 Crypt of the Damned"
            ,"5 Ruinous Crypt"
            ,"6 Decaying Crypt"
            ,"7 Vibrant Grotto"
            ,"8 Gloomhaven Warehouse"
            ,"9 Diamond Mine"
            ,"10 Plane of Elemental Power"
            ,"11 Gloomhaven Square A"
            ,"12 Gloomhaven Square B"
            ,"13 Temple of the Seer"
            ,"14 Frozen Hollow"
            ,"15 Shrine of Strength"
            ,"16 Mountain Pass"
            ,"17 Lost Island"
            ,"18 Abandoned Sewers"
            ,"19 Forgotten Crypt"
            ,"20 Necromancer's Sanctum"
            ,"21 Infernal Throne"
            ,"22 Temple of the Elements"
            ,"23 Deep Ruins"
            ,"24 Echo Chamber"
            ,"25 Icecrag Ascent"
            ,"26 Ancient Cistern"
            ,"27 Ruinous Rift"
            ,"28 Outer Ritual Chamber"
            ,"29 Sanctuary of Gloom"
            ,"30 Shrine of the Depths"
            ,"31 Plane of Night"
            ,"32 Decrepit Wood"
            ,"33 Savvas Armory"
            ,"34 Scorched Summit"
            ,"35 Gloomhaven Battlements A"
            ,"36 Gloomhaven Battlements B"
            ,"37 Doom Trench"
            ,"38 Slave Pens"
            ,"39 Treacherous Divide"
            ,"40 Ancient Defense Network"
            ,"41 Timeworn Tomb"
            ,"42 Realm of the Voice"
            ,"43 Drake Nest"
            ,"44 Tribal Assault"
            ,"45 Rebel Swamp"
            ,"46 Nightmare Peak"
            ,"47 Lair of the Unseeing Eye"
            ,"48 Shadow Weald"
            ,"49 Rebel's Stand"
            ,"50 Ghost Fortress"
            ,"51 The Void"
            ,"52 Noxious Cellar"
            ,"53 Crypt Basement"
            ,"54 Palace of Ice"
            ,"55 Foggy Thicket"
            ,"56 Bandit's Wood"
            ,"57 Investigation"
            ,"58 Bloody Shack"
            ,"59 Forgotten Grove"
            ,"60 Alchemy Lab"
            ,"61 Fading Lighthouse"
            ,"62 Pit of Souls"
            ,"63 Magma Pit"
            ,"64 Underwater Lagoon"
            ,"65 Sulfur Mine"
            ,"66 Clockwork Cove"
            ,"67 Arcane Library"
            ,"68 Toxic Moor"
            ,"69 Well of the Unfortunate"
            ,"70 Chained Isle"
            ,"71 Windswept Highlands"
            ,"72 Oozing Grove"
            ,"73 Rockslide Ridge"
            ,"74 Merchant Ship"
            ,"75 Overgrown Graveyard"
            ,"76 Harrower Hive"
            ,"77 Vault of Secrets"
            ,"78 Sacrifice Pit"
            ,"79 Lost Temple"
            ,"80 Vigil Keep"
            ,"81 Temple of the Eclipse"
            ,"82 Burning Mountain"
            ,"83 Shadows Within"
            ,"84 Crystalline Cave"
            ,"85 Sun Temple"
            ,"86 Harried Village"
            ,"87 Corrupted Cove"
            ,"88 Plane of Water"
            ,"89 Syndicate Hideout"
            ,"90 Demonic Rift"
            ,"91 Wild Melee"
            ,"92 Back Alley Brawl"
            ,"93 Sunken Vessel"
            ,"94 Vermling Nest"
            ,"95 Payment Due"};


    public static List<String> bothScenarioNames;
    public static List<String> mainScenarioNames;
    public static List<String> sideScenarioNames;

    static {
        bothScenarioNames = new ArrayList<>(96);
        mainScenarioNames = new ArrayList<>(NUM_OF_FIRST_SIDE_QUEST);
        int i = 0;
        for (; i < NUM_OF_FIRST_SIDE_QUEST; i++) {
            bothScenarioNames.add(scenarioNames[i]);
            mainScenarioNames.add(scenarioNames[i]);
        }
        sideScenarioNames = new ArrayList<>(TOTAL_NUM_SCENARIOS - NUM_OF_FIRST_SIDE_QUEST);
        for (; i < TOTAL_NUM_SCENARIOS; i++) {
            bothScenarioNames.add(scenarioNames[i]);
            sideScenarioNames.add(scenarioNames[i]);
        }
    }
    private static Scenario[] scenarios = new Scenario[TOTAL_NUM_SCENARIOS];

    private String name;
    private Scenario(int number) {
        name = scenarioNames[number];
        scenarios[number] = this;
    }

    public String getName(){
        return name;
    }

    @Nullable
    public static Scenario getScenario(int number) {
        if (number < 0 || number >= TOTAL_NUM_SCENARIOS) {
            return null;
        }
        else if(scenarios[number] == null) {
            return new Scenario(number);
        }
        else {
            return scenarios[number];
        }
    }
}
