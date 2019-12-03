package wizards;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class playerCharacter
{
    private String name, characterClass, race, alignment, eyes, hair, skin;
    private int age, weight, height, str, dex, con, intel, wis, cha;
    private String save1, save2, skill1, skill2, skill3, skill4, shareCode;
    private final String[] classes, races, alignments, eyeColors, hairColors, skinColors;
    private final String[] saves, skills;
    
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    
    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }
    public String getCharacterClass() { return characterClass; }
    
    public void setRace(String race) { this.race = race; }
    public String getRace() { return race; }
    
    public void setAlignment(String alignment) { this.alignment = alignment; }
    public String getAlignment() { return alignment; }
    
    public void setEyes(String eyes) { this.eyes = eyes; }
    public String getEyes() { return eyes; }
    
    public void setHair(String hair) { this.hair = hair; }
    public String getHair() { return hair; }
    
    public void setSkin(String skin) { this.skin = skin; }
    public String getSkin() { return skin; }
    
    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }
    
    public void setWeight(int weight) { this.weight = weight; }
    public int getWeight() { return weight; }
    
    public void setHeight(int height) { this.height = height; }
    public int getHeight() { return height; }
    
    public void setStr(int str) { this.str = str; }
    public int getStr() { return str; }
    
    public void setDex(int dex) { this.dex = dex; }
    public int getDex() { return dex; }
    
    public void setCon(int con) { this.con = con; }
    public int getCon() { return con; }
    
    public void setIntel(int intel) { this.intel = intel; }
    public int getIntel() { return intel; }
    
    public void setWis(int wis) { this.wis = wis; }
    public int getWis() { return wis; }
    
    public void setCha(int cha) { this.cha = cha; }
    public int getCha() { return cha; }
    
    public void setSave1(String save1) { this.save1 = save1; }
    public String getSave1() { return save1; }
    
    public void setSave2(String save2) { this.save2 = save2; }
    public String getSave2() { return save2; }
    
    public void setSkill1(String skill1) { this.skill1 = skill1; }
    public String getSkill1() { return skill1; }
    
    public void setSkill2(String skill2) { this.skill2 = skill2; }
    public String getSkill2() { return skill2; }
    
    public void setSkill3(String skill3) { this.skill3 = skill3; }
    public String getSkill3() { return skill3; }
    
    public void setSkill4(String skill4) { this.skill4 = skill4; }
    public String getSkill4() { return skill4; }
    
    public void setShareCode(String shareCode) { this.shareCode = shareCode; }
    public String getShareCode() { return shareCode; }
    
    public playerCharacter()
    {
        this.classes = new String[]
            {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Ranger"
                , "Rogue", "Sorcerer", "Wizard"};
        this.races = new String[]
            {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Half-Orc"
                , "Halfling", "Human", "Tiefling"};
        this.alignments = new String[]
            {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral"
                    , "True Neutral", "Chaotic Neutral", "Lawful Evil"
                    , "Neutral Evil", "Chaotic Evil"};
        this.eyeColors = new String[]
            {"Amber", "Black", "Blue", "Brown", "Gold", "Gray", "Green"
                , "Hazel", "Red"};
        this.hairColors = new String[]
            {"Auburn", "Black", "Brown", "Blond", "Red", "Grey", "White"};
        this.skinColors = new String[]
            {"Pale", "Fair", "Tan", "Brown", "Dark Brown", "Black", "Green"
                , "Blue", "Red"};
        this.saves = new String[]
            {"Strength", "Dexterity", "Constitution", "Intelligence"
                , "Wisdom", "Charisma"};
        this.skills = new String[]
            {"Acrobatics", "Animal Handling", "Deception", "Intimidation"
                    , "Investigation", "Medicine", "Nature", "Perception"
                    , "Sleight of Hand", "Stealth"};
        characterClass = "Barbarian";
        race = "Dragonborn";
        alignment = "Lawful Good";
        eyes = "Amber";
        hair = "Auburn";
        skin = "Pale";
        age = weight = height = str = dex = con = intel = wis = cha = 0;
        name = shareCode = "";
        save1 = save2 = "Strength";
        skill1 = skill2 = skill3 = skill4 = "Acrobatics";
    }
    
    boolean isValidName(String name)
    {
        return !"".equals(name);
    }
    
    int convertToInt(String number)
    {
        int num = 0;
        try
        { 
            num = Integer.parseInt(number); 
        }
        catch(NumberFormatException e)
        {
            return num; 
        }
        if(num < 0)
            return 0;
        if(num > 999)
            return 999;
        return num;
    }
    
    int statIntCheck(int num)
    {
        if(num < 3)
            return 3;
        if(num > 18)
            return 18;
        return num;
    }
    
    boolean isValidShareCode(String sc)
    {
        if(sc.length() < 33)
        {
            System.out.println("String too short");
            return false;
        }
            
        String test = sc.substring(0, 33);
        for(int i = 0; i < test.length(); i++)
        {
            if(!Character.isDigit(test.charAt(i)))
            {
                System.out.println(test.charAt(i));
                System.out.println("Prefix not int");
                return false;
            }
        }
        
        return true;
    }
    
    void generateShareCode()
    {
    	shareCode="";
        str = statIntCheck(str);
        dex = statIntCheck(dex);
        con = statIntCheck(con);
        intel = statIntCheck(intel);
        wis = statIntCheck(wis);
        cha = statIntCheck(cha);
        shareCode += Arrays.asList(classes).indexOf(characterClass);
        shareCode += Arrays.asList(races).indexOf(race);
        shareCode += Arrays.asList(alignments).indexOf(alignment);
        shareCode += Arrays.asList(eyeColors).indexOf(eyes);
        shareCode += Arrays.asList(hairColors).indexOf(hair);
        shareCode += Arrays.asList(skinColors).indexOf(skin);
        if(age < 100)
            shareCode += "0";
        if(age < 10)
            shareCode += "0";
        shareCode += age;
        if(weight < 100)
            shareCode += "0";
        if(weight < 10)
            shareCode += "0";
        shareCode += weight;
        if(height < 100)
            shareCode += "0";
        if(height < 10)
            shareCode += "0";
        shareCode += height;
        shareCode += Arrays.asList(saves).indexOf(save1);
        shareCode += Arrays.asList(saves).indexOf(save2);
        shareCode += Arrays.asList(skills).indexOf(skill1);
        shareCode += Arrays.asList(skills).indexOf(skill2);
        shareCode += Arrays.asList(skills).indexOf(skill3);
        shareCode += Arrays.asList(skills).indexOf(skill4);
        if(str < 10)
            shareCode += "0";
        shareCode += str;
        if(dex < 10)
            shareCode += "0";
        shareCode += dex;
        if(con < 10)
            shareCode += "0";
        shareCode += con;
        if(intel < 10)
            shareCode += "0";
        shareCode += intel;
        if(wis < 10)
            shareCode += "0";
        shareCode += wis;
        if(cha < 10)
            shareCode += "0";
        shareCode += cha;
        shareCode += name;
    }
    
    void exportToTxt()
    {
        try
        {
            FileWriter fileWriter = new FileWriter("C:/Users/Bill/Desktop/"+name+".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("NAME: " + name);
            printWriter.println("CLASS: " + characterClass);
            printWriter.println("RACE: " + race);
            printWriter.println("ALIGNMENT: " + alignment);
            printWriter.println("STRENGTH: " + str);
            printWriter.println("DEXTERITY: " + dex);
            printWriter.println("CONSTITUTION: " + con);
            printWriter.println("INTELLIGENCE: " + intel);
            printWriter.println("WISDOM: " + wis);
            printWriter.println("CHARISMA: " + cha);
            printWriter.println("EYES: " + eyes);
            printWriter.println("HAIR: " + hair);
            printWriter.println("SKIN: " + skin);
            printWriter.println("AGE: " + age);
            printWriter.println("WEIGHT: " + weight + " kg");
            printWriter.println("HEIGHT: " + height + " cm");
            printWriter.println("SAVING THROW 1: " + save1);
            printWriter.println("SAVING THROW 2: " + save2);
            printWriter.println("SKILL 1: " + skill1);
            printWriter.println("SKILL 2: " + skill2);
            printWriter.println("SKILL 3: " + skill3);
            printWriter.println("SKILL 4: " + skill4);
            printWriter.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(playerCharacter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}