import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Synthesizer;

public class Person2 extends Thread{
    String[] phrase ={"Invece","io","ti","interrompo","a","caso","perchè","voglio","rimanere","ignorante"};
    public Person2(String name){
        super(name);
    }
    public void run(){
        try {
// Set property as Kevin Dictionary
            System.setProperty(
                    "freetts.voices",
                    "com.sun.speech.freetts.en.us"
                            + ".cmu_us_kal.KevinVoiceDirectory");

// Register Engine

            Central.registerEngineCentral(
                    "com.sun.speech.freetts"
                            + ".jsapi.FreeTTSEngineCentral");

// Create a Synthesizer
            Synthesizer synthesizer
                    = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));

// Allocate synthesizer
            synthesizer.allocate();

// Resume Synthesizer
            synthesizer.resume();

// Speaks the given text
// until the queue is empty.
            for(String s : phrase) {
                System.out.println("Sono " + Thread.currentThread().getName() + ", parola: " + s);
                synthesizer.speakPlainText(
                        s, null);
                synthesizer.waitEngineState(
                        Synthesizer.QUEUE_EMPTY);
            }


// Deallocate the Synthesizer.
            synthesizer.deallocate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
