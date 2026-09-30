package study.java.practice.classes.day27_20260916;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        /*
         内部クラスとして、lightningメソッドを持つSpellクラスを定義してください。また、Skillクラスのuseメソッドから、Spellクラスをインスタンス化し、lightningメソッドを使用するコードを追加してください。
        */
        Skill skill = new Skill();
        skill.use();

        /*
         内部クラスとしてSpellクラスが定義されています。Spellクラスに定義されたlightningメソッドを使用するため、Spellクラスを外からインスタンス化し、Spellクラスのlightningメソッドを呼び出すコードを追加してください。
        */
        // Skillクラス をインスタンス化する
        Skill skill1 = new Skill();
        // 内部クラスを外から spell というインスタンス変数としてインスタンス化する処理を記述
        Skill.Spell spell1 = skill1.new Spell();
        // Spellクラス に定義された lightningメソッドを呼び出す処理を記述
        spell1.lightning();

        /*
         外側のクラスであるSkillクラス内のインスタンス変数enemyにスライムを代入し、enemy変数を呼び出す形でSpellクラスに定義されたlightningメソッドを、
          スライムにライトニングを放った
         となるよう、コードを変更してください。
        */
        // Skillクラス をインスタンス化する
        Skill skill2 = new Skill();
        // 内部クラスを外から spell というインスタンス変数としてインスタンス化する処理を記述
        Skill.Spell spell2 = skill2.new Spell();

        skill2.use1("スライム");

        /*
         外側のクラスであるSkillクラス内のメソッドであるlearnedをSpellクラスに定義されたlearnedSpellメソッドを使って呼び出す形で、
          スキルを覚えた
         となるよう、コードを変更してください。
        */
        Skill skill3 = new Skill();

        Skill.Spell spell3 = skill3.new Spell();
        spell3.learnedSpell();
    }
}

class Skill {
    // Skillクラス の内部クラスを定義
    class Spell {
        private String enemy;
        private String name = "スキル";

        void lightning() {
            System.out.println("ライトニング");
        }

        void lightning1(String enemy) {
            System.out.println(enemy + "にライトニングを放った");
        }

        void learnedSpell() {
            learned(name);
        }
    }

    private void learned(String name) {
        System.out.println(name + "を覚えた");
    }

    void use() {
        // Skillクラス の内部クラスである Spellクラス をインスタンス化するコードを記述
        Spell skill = new Spell();
        skill.lightning();
    }

    void use1(String enemy) {
        // Skillクラス の内部クラスである Spellクラス をインスタンス化するコードを記述
        Spell skill = new Spell();
        skill.lightning1(enemy);
    }
}
