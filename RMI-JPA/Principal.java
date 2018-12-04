public class Principal extends javax.swing.JFrame
{
Alumno alum;
Carrera car;
Reporte r;
Interfaz inter;
public Principal()
{
initComponents();
rmi();
alum = new Alumno(inter);
alum.setVisible(false);
car = new Carrera(inter);
car.setVisible(false);
r = new Reporte(inter);
r.setVisible(false);

jDesktopPane1.add(alum);
jDesktopPane1.add(car);
jDesktopPane1.add(r);
}
@SuppressWarnings("unchecked")

// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-
BEGIN:initComponents

private void initComponents() {
jDesktopPane1 = new javax.swing.JDesktopPane();
jMenuBar1 = new javax.swing.JMenuBar();
jMenu1 = new javax.swing.JMenu();
jMenuItem1 = new javax.swing.JMenuItem();
jMenu2 = new javax.swing.JMenu();
jMenuItem3 = new javax.swing.JMenuItem();
jMenuItem4 = new javax.swing.JMenuItem();
jMenu4 = new javax.swing.JMenu();
jMenuItem5 = new javax.swing.JMenuItem();
jMenu3 = new javax.swing.JMenu();
jMenuItem2 = new javax.swing.JMenuItem();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
javax.swing.GroupLayout jDesktopPane1Layout = new
javax.swing.GroupLayout(jDesktopPane1);
jDesktopPane1.setLayout(jDesktopPane1Layout);
jDesktopPane1Layout.setHorizontalGroup(
jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGap(0, 855, Short.MAX_VALUE)
);
jDesktopPane1Layout.setVerticalGroup(
jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGap(0, 624, Short.MAX_VALUE)
);
jMenu1.setText("Archivo");
jMenuItem1.setText("Cerrar");
jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jMenuItem1ActionPerformed(evt);
}
});

jMenu1.add(jMenuItem1);
jMenuBar1.add(jMenu1);
jMenu2.setText("Operaciones");
jMenuItem3.setText("Carrera");
jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jMenuItem3ActionPerformed(evt);
}
});
jMenu2.add(jMenuItem3);
jMenuItem4.setText("Alumno");
jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jMenuItem4ActionPerformed(evt);
}
});
jMenu2.add(jMenuItem4);
jMenu4.setText("Reportes");
jMenuItem5.setText("Alumnos x Carrera");
jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jMenuItem5ActionPerformed(evt);
}
});
jMenu4.add(jMenuItem5);
jMenu2.add(jMenu4);
jMenuBar1.add(jMenu2);
jMenu3.setText("Ayuda");
jMenuItem2.setText("Acerca de...");
jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jMenuItem2ActionPerformed(evt);
}
});
jMenu3.add(jMenuItem2);
jMenuBar1.add(jMenu3);

setJMenuBar(jMenuBar1);
javax.swing.GroupLayout layout = new
javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jDesktopPane1)
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jDesktopPane1)
);
pack();
}// </editor-fold>//GEN-END:initComponents

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-
FIRST:event_jMenuItem1ActionPerformed

this.dispose();
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-
FIRST:event_jMenuItem3ActionPerformed

alum.setVisible(true);
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-
FIRST:event_jMenuItem2ActionPerformed

JOptionPane.showMessageDialog(null, "Ejercicio 9 \n Nombre: Garcia Cebada
Jorge Miguel \n Materia: Diseño de Sistemas Distribuidos\n Profesor: Jose Asunción
Enríquez Zárate" );
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-
FIRST:event_jMenuItem4ActionPerformed

car.setVisible(true);
}//GEN-LAST:event_jMenuItem4ActionPerformed

private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-
FIRST:event_jMenuItem5ActionPerformed

r.setVisible(true);
}//GEN-LAST:event_jMenuItem5ActionPerformed
/**
* @param args the command line arguments

*/
public static void main(String args[]) {
/* Set the Nimbus look and feel */
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code
(optional) ">
/* If Nimbus (introduced in Java SE 6) is not available, stay with the default
look and feel.
* For details see
http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
*/
try {
for (javax.swing.UIManager.LookAndFeelInfo info :
javax.swing.UIManager.getInstalledLookAndFeels()) {
if ("Nimbus".equals(info.getName())) {
javax.swing.UIManager.setLookAndFeel(info.getClassName());
break;
}
}
} catch (ClassNotFoundException ex) {
java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Le
vel.SEVERE, null, ex);
} catch (InstantiationException ex) {
java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Le
vel.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Le
vel.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Le
vel.SEVERE, null, ex);
}
//</editor-fold>
/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
new Principal().setVisible(true);
}
});
}
public void rmi()
{

try
{
inter = (Interfaz) Naming.lookup("rmi://localhost/registroalum");
}
catch (NotBoundException | MalformedURLException | RemoteException ex)
{
Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
}
}
// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JDesktopPane jDesktopPane1;
private javax.swing.JMenu jMenu1;
private javax.swing.JMenu jMenu2;
private javax.swing.JMenu jMenu3;
private javax.swing.JMenu jMenu4;
private javax.swing.JMenuBar jMenuBar1;
private javax.swing.JMenuItem jMenuItem1;
private javax.swing.JMenuItem jMenuItem2;
private javax.swing.JMenuItem jMenuItem3;
private javax.swing.JMenuItem jMenuItem4;
private javax.swing.JMenuItem jMenuItem5;
// End of variables declaration//GEN-END:variables