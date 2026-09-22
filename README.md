Lemonade App

An interactive Android application built with modern **Jetpack Compose** as part of Google's *Android Basics with Compose* coursework.

Features & Highlights
- **Declarative UI**: Clean layout built entirely with Compose (`Scaffold`, `CenterAlignedTopAppBar`, `Column`, `Button`, `Image`).
- **State Management**: Handling UI states and dynamic screen transitions using `remember` and `mutableStateOf`.
- **Interactive Logic**: Simulated lemon-squeezing mechanics with randomized tap counters.
- **Custom Styling**: Rounded button shapes, Material 3 theming, and resource management (`stringResource`, `painterResource`).

Tech Stack
- **Language**: Kotlin
- **UI Toolkit**: Jetpack Compose (Material 3)
- **Architecture**: Single Activity, State hoisting basics
- **Min SDK**: 24+






Lemonade App

Googleの公式教材「Android Basics with Compose」の一環として開発した、Jetpack ComposeによるインタラクティブなAndroidアプリです。

アプリ概要
レモンの木からレモンを収穫し、絞ってレモネードを作って飲むまでの一連のサイクルを画面タップで進行するアプリです。

- **ステップ1**: レモンの木をタップしてレモンを収穫
- **ステップ2**: 指定された回数（ランダム）レモンをタップして果汁を絞る
- **ステップ3**: 完成したレモネードをタップして飲む
- **ステップ4**: 空になったグラスをタップして最初に戻る

技術スタック & 学習ポイント
- **言語**: Kotlin
- **UIツールキット**: Jetpack Compose (Material 3)
- **状態管理 (State Management)**:
  - `remember` と `mutableStateOf` を用いたUI状態の保持・再構成（Recomposition）の制御
- **レイアウト構成**:
  - `Scaffold` および `CenterAlignedTopAppBar` を用いた画面設計
  - `Column`、`Spacer` による柔軟なコンポーネント配置
  - `RoundedCornerShape` やカスタムカラーによるボタンのスタイリング
- **リソース管理**:
  - `stringResource` や `painterResource` を活用した多言語対応・画像リソースの適切な分離
