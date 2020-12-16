package bsu.rfe.java.group8.Buben.var12B;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame
{
    // Размеры окна приложения
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;

    // Текстовые поля для считывания значений переменных
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;

    private JTextField textFieldResult;
    private JTextField textMemoryField;

    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    private  ButtonGroup radioMemoryButtons = new ButtonGroup();

    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hboxMemoryType = Box.createHorizontalBox();

    private int formulaId = 1;
    private int memoryId = 1;
    private Double mem1 = 0.0;
    private Double mem2 = 0.0;
    private Double mem3 = 0.0;
    public Double calculate1(Double x, Double y, Double z)
    {}
    public Double calculate2(Double x, Double y, Double z)
    {}
    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId)
    {
        // Создать экземпляр радио-кнопки с заданным текстом
        JRadioButton button = new JRadioButton(buttonName);
        // Определить и зарегистрировать обработчик
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                Main.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
    private void addMemoryRadioButton(String buttonName, final int memoryId)
    {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Main.this.memoryId = memoryId;
                if (memoryId == 1)
                    textMemoryField.setText(Main.this.mem1.toString());
                if (memoryId == 2)
                    textMemoryField.setText(Main.this.mem2.toString());
                if (memoryId == 3)
                    textMemoryField.setText(Main.this.mem3.toString());
            }
        });
        radioMemoryButtons.add(button);
        hboxMemoryType.add(button);
    }
    public Main() {
        super("Math window");
        setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        //Позиционирование окна на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        // Добавить «клей» C1-H1 с левой стороны
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Formula 1", 1);
        addRadioButton("Formula 2", 2);
        // Установить выделенной 1-ую кнопку из группы
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        // Добавить «клей» C1-H2 с правой стороны
        hboxFormulaType.add(Box.createHorizontalGlue());
        // Задать рамку для коробки с помощью класса BorderFactory
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        // Создать область с полями ввода для X, Y, Z
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        // Установить макс размер = желаемому для предотвращения масштабирования
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
	// write your code here
    }
    public static void main(String[] args)
    {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
