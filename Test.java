import java.awt.*;
public class Test extends Frame
{

	Label pro;
	Test()
	{
		pro=new Label("zhunsssi");
		setLayout(new FlowLayout());
		add(pro);
		setSize(260,100);
		setVisible(true);
	}

	public static void main(String ar[])
	{
		new Test();
	}
}



