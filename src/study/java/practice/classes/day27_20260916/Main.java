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

        /*
         外側のクラスであるSkillクラス内の変数、nameと同名の変数を内部クラスであるSpellクラスで定義し、learnedメソッドの引数として与える形で呼び出すことで、
          スキルを覚えた
          メガライトニングを覚えた
         となるよう、コードを変更してください。
        */
        Skill skill4 = new Skill();
        skill4.use2();

        Skill.Spell spell4 = skill4.new Spell();
        spell4.learnedSpell1();
    }
}

class Skill {
    private String name = "スキル";

    // Skillクラス の内部クラスを定義
    class Spell {
        private String enemy;
        private String name = "メガライトニング";

        void lightning() {
            System.out.println("ライトニング");
        }

        void lightning1(String enemy) {
            System.out.println(enemy + "にライトニングを放った");
        }

        void learnedSpell() {
            learned(name);
        }
        void learnedSpell1() {
            // Skillクラス の name変数 を使用するコードを記述
            learned1(Skill.this.name);
            // Spellクラス の name変数 を使用するコードを記述
            learned1(name);
        }
    }

    private void learned(String name) {
        System.out.println(name + "を覚えた");
    }

    private void learned1(String skillname) {
        System.out.println(skillname + "を覚えた");
    }

    void learnedSpell() {
        // Skillクラス の name変数 を使用するコードを記述
        learned(Skill.this.name);
        // Spellクラス の name変数 を使用するコードを記述
        learned(name);
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

    void use2() {
        Spell skill = new Spell();
    }
}
