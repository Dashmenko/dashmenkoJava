using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.IO;
namespace WindowsFormsApplication7
{
    public partial class Form1 : Form
    {
        List<string> WordsDB = new List<string>();
        string lastWord = string.Empty;

        public Form1()
        {
            InitializeComponent();

            //считываем список в Лист
            using (StreamReader sr = new StreamReader("1.txt", Encoding.Default))
            {
                while (sr.Peek() != -1)
                    WordsDB.Add(sr.ReadLine()); //добавляем элементы
            }
        }


        private void textBox1_KeyDown(object sender, KeyEventArgs e)
        {
            //нажатие по Энтеру
            if (e.KeyCode == Keys.Enter)
            {
                try
                {
                    //проверка соответствия первой буквы
                    if (textBox1.Text[0] != lastWord[lastWord.Length - 1])
                    {
                        MessageBox.Show("Введите слово по правилам игры!");
                        return;
                    }
                }
                catch { }

                //если слово уже вводили
                if (listBox1.Items.Contains("<-- " + textBox1.Text) || listBox1.Items.Contains("--> " + textBox1.Text))
                {
                    MessageBox.Show("Это слово уже было!");
                    textBox1.Text = "";
                }
                else //новое слово
                {
                    //добавляем в список
                    listBox1.Items.Add("--> " + textBox1.Text);

                    //если такого слова не было в базе - добавляем
                    if (!WordsDB.Contains(textBox1.Text))
                        using (StreamWriter sw = new StreamWriter("1.txt", true, Encoding.Default))
                            sw.WriteLine(textBox1.Text);

                    //флаг - найдено/нет
                    bool found = false;
                    foreach (string str in WordsDB) //перебор по всем словам в листе
                    {
                        if (textBox1.Text[textBox1.Text.Length - 1] == str[0]) //просмотр по первой букве
                        {
                            if (listBox1.Items.Contains("<-- " + str) || listBox1.Items.Contains("--> " + str)) //если уже было
                                continue; //ищем дальше

                            listBox1.Items.Add("<-- " + str); //слово найдено - выводим

                            lastWord = str; //последнее слово

                            textBox1.Text = string.Empty; //очистка
                            textBox1.Focus(); //фокус для ввода
                            found = true; //активируем флаг
                            break; //выходим из цикла - больше нам тут делать нечего
                        }
                    }
                    if (!found)
                    {
                        if (MessageBox.Show("Компьютер не нашел ответа, ты выиграл!\r\nPlay again?", "", MessageBoxButtons.YesNo) == DialogResult.Yes) //победа - предложение сыграть еще
                            //считываем базу заново, обнуляя всё что можно
                            using (StreamReader sr = new StreamReader("1.txt", Encoding.Default))
                            {
                                WordsDB.Clear();
                                listBox1.Items.Clear();
                                textBox1.Text = "";
                                while (sr.Peek() != -1)
                                    WordsDB.Add(sr.ReadLine());
                            }
                    }
                }
            }
        }
    }
}
