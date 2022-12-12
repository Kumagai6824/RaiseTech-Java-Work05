## 第五回課題

* 今までの課題でGitHubにpushしたコードを変更してPull Requestを作成しましょう。
* Pull Requestのレビューを講師・メンターに依頼しましょう。
* レビューが完了したらマージしましょう。
* マージ後はローカルPCのデフォルトブランチ（mainブランチ）にcheckoutしてマージした内容をpullしましょう。

#### スーパーでお買い物するイメージのプログラムを作った

#### Productsクラス

* フィールドに、商品名、カテゴリー、値段を持つ

#### Categoryクラス（enum）

* 野菜、肉、調味料の定数を持つ

#### Mainクラス

* 商品リスト（productsList）をMapとして作成し、1から9までの数値キーと紐づけ
* カテゴリー毎に1つ好きな商品の数値キーを入力させる
* もしカテゴリーの範囲外の数値を入力すると、NoSuchKeyExceptionを投げ、再度入力を促す
* 最後に商品の合計金額を表示する

#### NoSuchKeyException

* オリジナル例外

#### 実行結果

```
"Let's go get groceries!" simulator<1.0>
Choose what you need for dinner...

--------------------
    [Vegetable]
--------------------
< 1 > Onion : ¥ 150
< 2 > Carrot : ¥110
< 3 > Potato : ¥110
--------------------
    [Meat & Fish]
--------------------
< 4 > Beef : ¥ 400
< 5 > Chicken : ¥300
< 6 > Salmon : ¥400
--------------------
    [Spice]
--------------------
< 7 > Black Pepper : ¥ 130
< 8 > Herb : ¥200
< 9 > Curry Spice : ¥300

Type one of the numbers from the Vegetable category below and press enter.

```

#### 実行結果（入力後）

```
Type one of the numbers from the Vegetable category below and press enter.
2
You chose...Carrot


Type one of the numbers from the Meat & Fish category below and press enter.
5
You chose...Chicken


Type one of the numbers from the Spice category below and press enter.
9
You chose...Curry Spice

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
You paid ¥710 at the supermarket!
Let's go home & cook!!
((o(・ρ・)o)) ﾊﾗﾍｯﾀｧ");
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

```
