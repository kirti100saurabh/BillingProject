package com.teleteach.billing.view;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.teleteach.billing.service.PurchaseReportService;
import com.teleteach.billing.vo.PurchaseReportVO;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import reports.ReportTemplate1;

public class PurchaseWeeklyReportView extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private DefaultComboBoxModel<String> model;
	private DefaultComboBoxModel<String> monthmodel;
	private JComboBox<String> monthsel;
	private JComboBox<String> comboBox;

	/**
	 * Create the panel.
	 */
	public static void main(String[] args) {
		
		create();
	}

	public static void create() {
		f = new JFrame("Purchase Weekly Report");
		f.getContentPane().add(new PurchaseWeeklyReportView());
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		int w = 310, h = 300;
		f.setLocation(width / 2 - (w / 2), height / 2 - (h / 2));

		f.setSize(w, h);
		f.setVisible(true);
	}

	public PurchaseWeeklyReportView() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 271, 225);
		add(panel);
		panel.setLayout(null);

		JLabel lblSelectMonth = new JLabel("Select Month :");
		lblSelectMonth.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));
		lblSelectMonth.setBounds(26, 26, 104, 27);
		panel.add(lblSelectMonth);

		JLabel lblSelectStartDate = new JLabel("Select Start Date :");
		lblSelectStartDate.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));
		lblSelectStartDate.setBounds(26, 82, 152, 27);
		panel.add(lblSelectStartDate);

		model = new DefaultComboBoxModel<String>(new String[] { "1", "8", "15", "22", "29" });
		comboBox = new JComboBox<String>(model);
		comboBox.setBounds(157, 86, 78, 20);
		panel.add(comboBox);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseReportService purchaseReportService = new PurchaseReportService();
				List<PurchaseReportVO> reportRows = purchaseReportService.getPurchaseReport(
						(Integer.parseInt("" + (monthsel.getSelectedIndex() + 1))),
						(Integer.parseInt("" + comboBox.getSelectedItem()) + 1));
				Vector<String> attr = new Vector<String>();
				attr.add("GRNNO");
				attr.add("SupplierName");
				attr.add("BILL");
				attr.add("PurchaseDate");
				if (reportRows != null) {
					DynamicReport dr = getDynamicReport(attr, "Report Of Purchase", "General Store");
					JasperPrint jp = null;
					try {

						jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), reportRows);
						JasperViewer.viewReport(jp, false);
					} catch (JRException e1) {
						e1.printStackTrace();
					}

				}

			}
		});
		btnOk.setBounds(157, 140, 78, 23);
		panel.add(btnOk);

		monthmodel = new DefaultComboBoxModel<String>((new DateFormatSymbols()).getShortMonths());
		monthsel = new JComboBox<String>(monthmodel);
		monthsel.setBounds(157, 30, 78, 20);
		monthsel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (monthsel.getSelectedIndex() == 1) {
					model.removeElement("29");
				} else if (!(model.getIndexOf("29") > 0))
					model.addElement("29");

			}
		});
		panel.add(monthsel);

	}

	public static DynamicReport getDynamicReport(Vector<String> v, String title, String subtitle) {

		Style headerStyle = createHeaderStyle();
		Style detailTextStyle = createDetailTextStyle();
		// Style detailNumberStyle = createDetailNumberStyle();

		DynamicReportBuilder report = new DynamicReportBuilder();

		for (String attr : v) {

			AbstractColumn column = createColumn(attr, String.class, attr, 30, headerStyle, detailTextStyle);

			// if(attr.equals("DOB"))
			// column = createColumn("Int([DOB])",
			// java.sql.Date.class,"BirthDate", 30, headerStyle,
			// detailTextStyle);
			report.addColumn(column);
		}
		StyleBuilder titleStyle = new StyleBuilder(true);
		titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
		titleStyle.setFont(new Font(20, Font._FONT_GEORGIA, true));

		StyleBuilder subTitleStyle = new StyleBuilder(true);
		subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
		subTitleStyle.setFont(new Font(Font.MEDIUM, Font._FONT_GEORGIA, true));

		report.setOddRowBackgroundStyle(ReportTemplate1.setOddRowStyle());
		report.setTitle(title);
		report.setTitleStyle(titleStyle.build());
		report.setSubtitle(subtitle);
		report.setSubtitleStyle(subTitleStyle.build());
		report.setUseFullPageWidth(true);
		// report.setTemplateFile("D:\\study\\java\\Reports\\template1.jrxml");
		return report.build();
	}

	public static Style createDetailNumberStyle() {
		StyleBuilder sb = new StyleBuilder(true);
		sb.setFont(Font.VERDANA_MEDIUM);
		sb.setBorder(Border.DOTTED());
		sb.setBorderColor(Color.BLACK);
		sb.setTextColor(Color.BLACK);
		sb.setHorizontalAlign(HorizontalAlign.RIGHT);
		sb.setVerticalAlign(VerticalAlign.MIDDLE);
		sb.setPaddingRight(5);
		return sb.build();
	}

	public static Style createDetailTextStyle() {
		StyleBuilder sb = new StyleBuilder(true);
		sb.setFont(Font.VERDANA_MEDIUM);
		sb.setBorder(Border.DOTTED());
		sb.setBorderColor(Color.BLACK);
		sb.setTextColor(Color.BLACK);
		sb.setHorizontalAlign(HorizontalAlign.LEFT);
		sb.setVerticalAlign(VerticalAlign.MIDDLE);
		sb.setPaddingLeft(5);
		return sb.build();
	}

	public static AbstractColumn createColumn(String property, Class<String> type, String title, int width,
			Style headerStyle, Style detailStyle) throws ColumnBuilderException {
		AbstractColumn columnState = ColumnBuilder.getNew().setColumnProperty(property, type.getName()).setTitle(title)
				.setWidth(Integer.valueOf(width)).setStyle(detailStyle).setHeaderStyle(headerStyle).build();
		return columnState;
	}

	public static Style createHeaderStyle() {

		StyleBuilder sb = new StyleBuilder(false);
		sb.setFont(Font.VERDANA_MEDIUM_BOLD);
		sb.setBorder(Border.THIN());
		sb.setBorderBottom(Border.PEN_2_POINT());
		sb.setBorderColor(Color.RED);
		sb.setBackgroundColor(new Color(238, 130, 238));
		sb.setTextColor(Color.BLACK);
		sb.setHorizontalAlign(HorizontalAlign.CENTER);
		sb.setVerticalAlign(VerticalAlign.MIDDLE);
		sb.setTransparency(Transparency.OPAQUE);
		return sb.build();

	}

}
