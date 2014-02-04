package com.hfs.utils;

import java.util.Random;

/**
 * @author Matt
 *
 */
/**
 * @author Matt
 *
 */
public class NameGen {
	
	// class attributes
	private String name = ""; // hero name
	private int prefixIndex = 0;
	private int suffixIndex = 0;
	
	// utility variables - general
	private Random random = new Random(); // random number generator
	
	// Hero Name Generator - constants 
	private static final String[] HERO_NAME_PREFIX = {"Tank", "Missle", "Book", "Crunch", "Blade", "Day", "Lung", "Horse", "Rhino", "Reindeer", "Junk", "Spleen", "Carrot", "Tomato", "Titanium", "Helium", "Hydrogen", "Xeon", "Mercury", "Shine", "Sun", "Moon", "Flame", "Mushroom", "Truth", "Punch", "Kick", "Karate", "Bruise", "Vertex", "Vortex", "Bun", "Hot", "Cold", "Grease", "Breeze", "Wind", "Cloud", "Space", "Star", "Bull", "Blizzard", "Rocket", "Thief", "Crook", "Bam", "Patch", "Leotard", "Burrito", "Broom", "Freedom", "Day", "Night", "Sword", "Laser", "Plasma", "Jam", "Foot", "Zebra", "Lion", "Panther", "Sloth", "Frog", "Coffee", "Energy", "Gnu", "Emu", "Toe", "Snow", "Cheese", "Nebula", "Saturn", "Gravy", "Smart", "Mind", "Fork", "Spoon", "Bacon", "Ramen", "Sushi", "Spaghetti", "Zoo", "Karma", "Good", "Para", "Edge"};
	private static final String[] VILLAIN_NAME_PREFIX = {"Evil", "Octopus", "Squid", "Mattress", "Fudge", "Hades", "Blood", "Bung", "Stab", "Vein", "Brain", "Fire", "Magma", "Sulfur", "Acid", "Fungus", "Dookie", "Kill", "Knife", "Bald", "Grudge", "Machete", "Small", "Dim", "Crack", "Wart", "Goiter", "Gout", "Chum", "Gray", "Grey", "Donkey", "Butcher", "Jester", "Oil", "Python", "Bone", "Sinew", "Virus", "Mold", "Mildew", "Flea", "Parasite", "Dinosaur", "Dynamite", "Exploder", "Robot", "Off", "Bot", "Bad", "Pain", "Cyber", "Bolt", "Enchant", "Mirage", "Lynx", "Bark", "Chop", "Boil", "Goon", "Cleaver", "Berzerk", "Lash", "Dino", "Pork" };
	
	private static final String[] HERO_NAME_SUFFIX = {" Man", "man", " Boy", "boy", " Woman", " Girl", "girl", "tron", " Tooth", " of Good", " Supreme", " the Bold", " the Brave", " Steel"};
	private static final String[] VILLAIN_NAME_SUFFIX = {"tor", "noid", " Man", "man", " Woman", " Girl", "girl", " Tooth", "saur", "ix", "atrix", "charge", "cron", "crux", " Pain", " Scientist", " of Evil", " Evil", " the Evil", " of Doom", " the Evil Knight", " Blaze"};
	
	public String generateName(int type) {
		// uses GameVars.HERO or GameVars.VILLAIN to generate the given type
		if (type == 0) {
			// generate a hero if true
			prefixIndex = random.nextInt(HERO_NAME_PREFIX.length);
			suffixIndex = random.nextInt(HERO_NAME_SUFFIX.length);
			name = HERO_NAME_PREFIX[prefixIndex] + HERO_NAME_SUFFIX[suffixIndex];
		} else {
			// generate a villain if false
			prefixIndex = random.nextInt(VILLAIN_NAME_PREFIX.length);
			suffixIndex = random.nextInt(VILLAIN_NAME_SUFFIX.length);
			name = VILLAIN_NAME_PREFIX[prefixIndex] + VILLAIN_NAME_SUFFIX[suffixIndex];
		}
		return name;
	}
}
