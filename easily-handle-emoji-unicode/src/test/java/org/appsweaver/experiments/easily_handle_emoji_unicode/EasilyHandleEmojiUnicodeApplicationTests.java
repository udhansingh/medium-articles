package org.appsweaver.experiments.easily_handle_emoji_unicode;

import java.util.List;

import org.appsweaver.experiments.easily_handle_emoji_unicode.EmojiUnicodePointAndValueMaker;
import org.appsweaver.experiments.easily_handle_emoji_unicode.UnicodePointEntry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 
 * @author udhansingh
 *
 */
@SpringBootTest
class EasilyHandleEmojiUnicodeApplicationTests {
	// true = Print code for ENUM; false=print with Unicode for visual inspection
	
	@Test
	public void testEmojiCodePointGeneration() throws Throwable {
		final EmojiUnicodePointAndValueMaker emojiUnicodePointAndValueMaker = new EmojiUnicodePointAndValueMaker();
		final List<UnicodePointEntry> entries = emojiUnicodePointAndValueMaker.build();
		
		final String syntax = System.getProperty("enumCompatibleSyntax");
		final boolean enumCompatible = (syntax != null) ? Boolean.valueOf(syntax) : true;
		
		// Display the entries
		for(int index = 0; index < entries.size(); index++) {
			final UnicodePointEntry entry = entries.get(index);
			
			if(enumCompatible) {
				System.out.println(
					String.format(
						"%s(%s)%s", 
						entry.getName(),
						entry.getCodesAsCSV(),
						(index < entries.size() - 1) ? "," : ""
					)
				);
			} else {
				System.out.println(
					String.format(
						"%d; %s; %s(%s)", 
						entry.getRow(),
						entry.toEmoji(),
						entry.getName(),
						entry.getCodesAsCSV()
					)
				);
			}
		}
	}
}
