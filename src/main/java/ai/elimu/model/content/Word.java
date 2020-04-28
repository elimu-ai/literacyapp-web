package ai.elimu.model.content;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;
import ai.elimu.model.enums.content.SpellingConsistency;
import ai.elimu.model.enums.content.WordType;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Word extends Content {

    @Deprecated // TODO: replace with list of Letters
    @NotNull
    private String text;
    
//    @NotEmpty
    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Letter> letters;
    
    @NotEmpty
    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Allophone> allophones;
    
    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<LetterToAllophoneMapping> letterToAllophoneMappings;
    
    private int usageCount; // Based on StoryBook content
    
    /**
     * As an example, the verb "reading" will be linked to the root verb "read".
     */
    @ManyToOne
    private Word rootWord;
    
    @Enumerated(EnumType.STRING)
    private WordType wordType;
    
//    @NotNull
    @Enumerated(EnumType.STRING)
    private SpellingConsistency spellingConsistency;

    @Deprecated
    public String getText() {
        return text;
    }

    @Deprecated
    public void setText(String text) {
        this.text = text;
    }
    
    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }
    
    public List<Allophone> getAllophones() {
        return allophones;
    }

    public void setAllophones(List<Allophone> allophones) {
        this.allophones = allophones;
    }
    
    public List<LetterToAllophoneMapping> getLetterToAllophoneMappings() {
        return letterToAllophoneMappings;
    }

    public void setLetterToAllophoneMappings(List<LetterToAllophoneMapping> letterToAllophoneMappings) {
        this.letterToAllophoneMappings = letterToAllophoneMappings;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
    }
    
    public Word getRootWord() {
        return rootWord;
    }

    public void setRootWord(Word rootWord) {
        this.rootWord = rootWord;
    }

    public WordType getWordType() {
        return wordType;
    }

    public void setWordType(WordType wordType) {
        this.wordType = wordType;
    }

    public SpellingConsistency getSpellingConsistency() {
        return spellingConsistency;
    }

    public void setSpellingConsistency(SpellingConsistency spellingConsistency) {
        this.spellingConsistency = spellingConsistency;
    }
}
