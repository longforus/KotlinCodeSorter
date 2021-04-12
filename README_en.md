# Kotlin Code Sorter

A simple plugin for sorting kotlin code.

  A small plugin that can sort Kotlin code. Recently in the daily development, I found that the code arrangement of Kotlin is not as good as that of Java. In IDEA or AndroidStudio, Java fields are usually in the front, and methods are in the back. It looks better than others. In Kotlin, however, the overridden variables and functions are arranged according to the order in which they are overwritten, with the last written first and the last written first. And the fields and functions are interspersed, really obsessive compulsive disorder.
   With this small plug-in, gently press the instant row, flattered.

![1](./img/1.gif)

## Features

-   Support for sorting code by the default order of fields -> initializer blocks -> constructors -> methods -> inner classes.
-   Since 1.2, you can customize the sort order in the Settings panel.

## Install

- **Use IDE built-in plugin market installation:**
  - <kbd>File</kbd> > <kbd>Preferences(Settings)</kbd> > <kbd>Plugins</kbd> > <kbd>Browse repositories...</kbd> > <kbd>搜索并找到"Kotlin code sotrer"</kbd> > <kbd>Install Plugin</kbd>

- **Manual:**
  - Download[`Latest Release`][latest-release] > <kbd>File</kbd> ><kbd>Preferences(Settings)</kbd> > <kbd>Plugins</kbd> > <kbd>Install plugin from disk...</kbd>

重启**IDE**.

## Use

1. Default shortcut Ctrl + Alt + K. You can modify it by yourself:
   ![2](./img/2.png)
   
2. Of course ,you can click<kbd>Code</kbd> > <kbd>Sort kotlin code</kbd> > <kbd>fields->initializer->constructors->functions</kbd> 

3. Click<kbd>File</kbd> ><kbd>Settings</kbd> ><kbd>Other Settings</kbd> ><kbd>Kotlin Code Sorter</kbd> You can adjust the order you like:

   ![3](./img/3.png)

   


Inspired by [Lifecycle Sorter](https://plugins.jetbrains.com/plugin/7742-lifecycle-sorter)

[latest-release]: https://plugins.jetbrains.com/plugin/11163-kotlin-code-sorter

