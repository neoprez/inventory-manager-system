package com.ims.gui;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.ims.classes.InventoryProduct;
import com.ims.components.DBUtilities;

import java.awt.print.*;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class generateReportView extends JFrame implements Printable, ActionListener {
		JButton cancelButton = new JButton("Cancel");
		JButton printButton = new JButton("Print");
		JButton resetButton = new JButton("Reset Field");
		JTextField searchField = new JTextField();
		JPanel buttonPanel = new JPanel();
		JLabel printLabel = new JLabel("Print Report");
		
		JScrollPane scrollPane = new JScrollPane();
		DBUtilities db = new DBUtilities();
		
		
		String[] columnNames = {"Name",
	            "UPC",
	            "Manufacturer",
	            "Distributor",
	            "Category", "Count"};
		
		
		
		Object[][] product;
		
		JTable table = new JTable( new DefaultTableModel(product, columnNames) );
		
		
		public generateReportView(){
			
		setSize(1280, 750);
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		add(searchField, BorderLayout.NORTH);
		
		
		add(buttonPanel, BorderLayout.EAST);
		
		buttonPanel.setLayout(new GridLayout(0,1));
		
		buttonPanel.add(printLabel);
		printLabel.setBorder(BorderFactory.createEmptyBorder(0, 165, 0, 0));
		
		buttonPanel.add(printButton);
		printButton.setPreferredSize(new Dimension(400, 200));
		printButton.addActionListener(this);
		
		buttonPanel.add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(400, 200));
		cancelButton.addActionListener(this);
		
		buttonPanel.add(resetButton);
		resetButton.setPreferredSize(new Dimension(400, 200));
		resetButton.addActionListener(this);
		
	
		ArrayList<InventoryProduct> products = db.getProductsOnInventoryForSupermarket(1);
		
		
		product = new Object[products.size()][6];
		
		int row= 0;
		
		for(InventoryProduct p: products) {
			product[row][0] = p.getName();
			product[row][1] = p.getUpc();
			product[row][2] = p.getManufacturer().getName();
			product[row][3] = p.getDistributor().getName();
			product[row][4] = p.getCategory().getName();
			product[row][5] = p.getCount();
			row++;	
		}
		
		
		table = new JTable( new DefaultTableModel(product, columnNames) );
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		}
	 
	    public int print(Graphics g, PageFormat pf, int page) throws
	                                                        PrinterException {
	 
	        if (page > 0) { /* We have only one page, and 'page' is zero-based */
	            return NO_SUCH_PAGE;
	        }
	 
	        /* User (0,0) is typically outside the imageable area, so we must
	         * translate by the X and Y values in the PageFormat to avoid clipping
	         */
	        Graphics2D g2d = (Graphics2D)g;
	        g2d.translate(pf.getImageableX(), pf.getImageableY());
	 
	        /* Now we perform our rendering */
	        g.drawString("Test", 100, 100);
	        
	        
	 
	        /* tell the caller that this page is part of the printed document */
	        return PAGE_EXISTS;
	    }
	 
	    public void actionPerformed(ActionEvent e) {
	         if(e.getActionCommand()==("Print")){
	        	 PrinterJob job = PrinterJob.getPrinterJob();
		         job.setPrintable(this);
	        	 try {
	        		    boolean complete = table.print();
	        		    if (complete) {
	        		        JOptionPane.showMessageDialog(null, "Your printing job was successful!");
	        		       
	        		    } else {
	        		    	JOptionPane.showMessageDialog(null, "Your printing job was cancelled.");
	        		       
	        		    }
	        		} catch (PrinterException pe) {
	        		    JOptionPane.showConfirmDialog(null,
	        					"There was an error. Please Try again.",
	        					null, JOptionPane.WARNING_MESSAGE);
	        		    
	        		}
	     	   
	         }
	         else if(e.getActionCommand()==("Cancel")){
					super.dispose();
				}
	         
	         else if(e.getActionCommand()==("Reset Field")){ 
	 			searchField.setText("");
	 		}
	        	 
	    }
	
}
