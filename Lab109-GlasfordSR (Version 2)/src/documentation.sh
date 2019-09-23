#This will save all of the *.java files into a single .txt file
cat *.java >> Lab109-GlasfordSR.txt

#This will add the ooutput to the txt document
cat output.txt >> Lab109-GlasfordSR.txt

#This will convert that .txt file to a .docx file
pandoc -o Lab109-GlasfordSR.docx Lab109-GlasfordSR.txt

#Execute the latex document as well to keep everything updated
pdflatex Lab109-GlasfordSR.latex