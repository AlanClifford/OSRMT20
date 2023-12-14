package com.osframework.modellibrary.reportwriter;

import java.io.Serializable;

/**
 * DTD
 * <?xml version="1.0" encoding="UTF-8"?>
<!ELEMENT jasperReport (property*, import*, reportFont*, style*, subDataset*, parameter*, queryString?, field*, variable*, group*, background?, title?, pageHeader?, columnHeader?, detail?, columnFooter?, pageFooter?, lastPageFooter?, summary?)>
<!ATTLIST jasperReport
	name NMTOKEN #REQUIRED
	language NMTOKEN "java"
	columnCount NMTOKEN "1"
	printOrder (Vertical | Horizontal) "Vertical"
	pageWidth NMTOKEN "595"
	pageHeight NMTOKEN "842"
	orientation (Portrait | Landscape) "Portrait"
	whenNoDataType (NoPages | BlankPage | AllSectionsNoDetail) "NoPages"
	columnWidth NMTOKEN "555"
	columnSpacing NMTOKEN "0"
	leftMargin NMTOKEN "20"
	rightMargin NMTOKEN "20"
	topMargin NMTOKEN "30"
	bottomMargin NMTOKEN "30"
	isTitleNewPage (true | false) "false"
	isSummaryNewPage (true | false) "false"
	isFloatColumnFooter (true | false) "false"
	scriptletClass NMTOKEN #IMPLIED
	resourceBundle CDATA #IMPLIED
	whenResourceMissingType (Null | Empty | Key | Error) "Null"
	isIgnorePagination (true | false) "false"
>

<!ELEMENT property EMPTY>
<!ATTLIST property
	name CDATA #REQUIRED
	value CDATA #IMPLIED
>

<!ELEMENT import EMPTY>
<!ATTLIST import
	value CDATA #REQUIRED
>

<!ELEMENT reportFont EMPTY>
<!ATTLIST reportFont
	name NMTOKEN #REQUIRED
	isDefault (true | false) "false"
	fontName CDATA "sansserif"
	size NMTOKEN "10"
	isBold (true | false) "false"
	isItalic (true | false) "false"
	isUnderline (true | false) "false"
	isStrikeThrough (true | false) "false"
	pdfFontName CDATA "Helvetica"
	pdfEncoding CDATA "CP1252"
	isPdfEmbedded (true | false) "false"
>

<!ELEMENT style (conditionalStyle*)>
<!ATTLIST style
	name NMTOKEN #IMPLIED
	isDefault (true | false) "false"
	style NMTOKEN #IMPLIED
	mode (Opaque | Transparent) #IMPLIED
	forecolor CDATA #IMPLIED
	backcolor CDATA #IMPLIED
	pen (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	fill (Solid) #IMPLIED
	radius NMTOKEN #IMPLIED
	scaleImage (Clip | FillFrame | RetainShape) #IMPLIED
	hAlign (Left | Center | Right | Justified) #IMPLIED
	vAlign (Top | Middle | Bottom) #IMPLIED
	border (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	borderColor CDATA #IMPLIED
	padding NMTOKEN #IMPLIED
	topBorder (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	topBorderColor CDATA #IMPLIED
	topPadding NMTOKEN #IMPLIED
	leftBorder (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	leftBorderColor CDATA #IMPLIED
	leftPadding NMTOKEN #IMPLIED
	bottomBorder (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	bottomBorderColor CDATA #IMPLIED
	bottomPadding NMTOKEN #IMPLIED
	rightBorder (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	rightBorderColor CDATA #IMPLIED
	rightPadding NMTOKEN #IMPLIED
	rotation (None | Left | Right) #IMPLIED
	lineSpacing (Single | 1_1_2 | Double) #IMPLIED
	isStyledText (true | false) #IMPLIED
	fontName CDATA #IMPLIED
	fontSize NMTOKEN #IMPLIED
	isBold (true | false) #IMPLIED
	isItalic (true | false) #IMPLIED
	isUnderline (true | false) #IMPLIED
	isStrikeThrough (true | false) #IMPLIED
	pdfFontName CDATA #IMPLIED
	pdfEncoding CDATA #IMPLIED
	isPdfEmbedded (true | false) #IMPLIED
	pattern CDATA #IMPLIED
	isBlankWhenNull (true | false) #IMPLIED
>

<!ELEMENT conditionalStyle (conditionExpression?, style)>

<!ELEMENT conditionExpression (#PCDATA)>

<!ELEMENT subDataset (property*, parameter*, queryString?, field*, variable*, group*)>
<!ATTLIST subDataset
	name NMTOKEN #REQUIRED
	scriptletClass NMTOKEN #IMPLIED
	resourceBundle CDATA #IMPLIED
	whenResourceMissingType (Null | Empty | Key | Error) "Null"
>

<!ELEMENT parameter (parameterDescription?, defaultValueExpression?)>
<!ATTLIST parameter
	name CDATA #REQUIRED
	class NMTOKEN "java.lang.String"
	isForPrompting (true | false) "true"
>
<!ELEMENT parameterDescription (#PCDATA)>
<!ELEMENT defaultValueExpression (#PCDATA)>

<!ELEMENT queryString (#PCDATA)>
<!ATTLIST queryString
	language NMTOKEN "sql"
>

<!ELEMENT field (fieldDescription?)>
<!ATTLIST field
	name CDATA #REQUIRED
	class NMTOKEN "java.lang.String"
>
<!ELEMENT fieldDescription (#PCDATA)>

<!ELEMENT variable (variableExpression?, initialValueExpression?)>
<!ATTLIST variable
	name CDATA #REQUIRED
	class NMTOKEN "java.lang.String"
	resetType (None | Report | Page | Column | Group) "Report"
	resetGroup CDATA #IMPLIED
	incrementType (None | Report | Page | Column | Group) "None"
	incrementGroup CDATA #IMPLIED
	calculation (Nothing | Count | Sum | Average | Lowest | Highest | StandardDeviation | Variance | System | First) "Nothing"
	incrementerFactoryClass NMTOKEN #IMPLIED
>
<!ELEMENT variableExpression (#PCDATA)>
<!ELEMENT initialValueExpression (#PCDATA)>

<!ELEMENT group (groupExpression?, groupHeader?, groupFooter?)>
<!ATTLIST group
	name NMTOKEN #REQUIRED
	isStartNewColumn (true | false) "false"
	isStartNewPage (true | false) "false"
	isResetPageNumber (true | false) "false"
	isReprintHeaderOnEachPage (true | false) "false"
	minHeightToStartNewPage NMTOKEN "0"
>
<!ELEMENT groupExpression (#PCDATA)>
<!ELEMENT groupHeader (band?)>
<!ELEMENT groupFooter (band?)>

<!ELEMENT background (band?)>
<!ELEMENT title (band?)>
<!ELEMENT pageHeader (band?)>
<!ELEMENT columnHeader (band?)>
<!ELEMENT detail (band?)>
<!ELEMENT columnFooter (band?)>
<!ELEMENT pageFooter (band?)>
<!ELEMENT lastPageFooter (band?)>
<!ELEMENT summary (band?)>

<!ELEMENT band (printWhenExpression?, (line | rectangle | ellipse | image | staticText | textField | subreport | pieChart | pie3DChart | barChart | bar3DChart | xyBarChart | stackedBarChart | stackedBar3DChart| lineChart | xyLineChart | areaChart | xyAreaChart | scatterChart | bubbleChart | timeSeriesChart | highLowChart | candlestickChart | elementGroup | crosstab | frame)*)>
<!ATTLIST band
	height NMTOKEN "0"
	isSplitAllowed (true | false) "true"
>

<!ELEMENT line (reportElement, graphicElement?)>
<!ATTLIST line
	direction (TopDown | BottomUp) "TopDown"
>

<!ELEMENT reportElement (printWhenExpression?)>
<!ATTLIST reportElement
	key NMTOKEN #IMPLIED
	style NMTOKEN #IMPLIED
	positionType (Float | FixRelativeToTop | FixRelativeToBottom) "FixRelativeToTop"
	stretchType (NoStretch | RelativeToTallestObject | RelativeToBandHeight) "NoStretch"
	isPrintRepeatedValues (true | false) "true"
	mode (Opaque | Transparent) #IMPLIED
	x NMTOKEN #REQUIRED
	y NMTOKEN #REQUIRED
	width NMTOKEN #REQUIRED
	height NMTOKEN #REQUIRED
	isRemoveLineWhenBlank (true | false) "false"
	isPrintInFirstWholeBand (true | false) "false"
	isPrintWhenDetailOverflows (true | false) "false"
	printWhenGroupChanges CDATA #IMPLIED
	forecolor CDATA #IMPLIED
	backcolor CDATA #IMPLIED
>
<!ELEMENT printWhenExpression (#PCDATA)>

<!ELEMENT graphicElement EMPTY>
<!ATTLIST graphicElement
	stretchType (NoStretch | RelativeToTallestObject | RelativeToBandHeight) #IMPLIED
	pen (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	fill (Solid) #IMPLIED
>

<!ELEMENT rectangle (reportElement, graphicElement?)>
<!ATTLIST rectangle
	radius NMTOKEN #IMPLIED
>

<!ELEMENT ellipse (reportElement, graphicElement?)>

<!ELEMENT image (reportElement, box?, graphicElement?, imageExpression?, anchorNameExpression?, hyperlinkReferenceExpression?, hyperlinkAnchorExpression?, hyperlinkPageExpression?)>
<!ATTLIST image
	scaleImage (Clip | FillFrame | RetainShape) #IMPLIED
	hAlign (Left | Center | Right) #IMPLIED
	vAlign (Top | Middle | Bottom) #IMPLIED
	isUsingCache (true | false) #IMPLIED
	isLazy (true | false) "false"
	onErrorType (Error | Blank | Icon) "Error"
	evaluationTime (Now | Report | Page | Column | Group | Band | Auto) "Now"
	evaluationGroup CDATA #IMPLIED
	hyperlinkType (None | Reference | LocalAnchor | LocalPage | RemoteAnchor | RemotePage) "None"
	hyperlinkTarget (Self | Blank) "Self"
	bookmarkLevel NMTOKEN "0"
>
<!ELEMENT imageExpression (#PCDATA)>
<!ATTLIST imageExpression
	class (java.lang.String | java.io.File | java.net.URL | java.io.InputStream | java.awt.Image | net.sf.jasperreports.engine.JRRenderable) "java.lang.String"
>

<!ELEMENT box EMPTY>
<!ATTLIST box
	border (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	borderColor CDATA #IMPLIED
	padding NMTOKEN #IMPLIED
	topBorder (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	topBorderColor CDATA #IMPLIED
	topPadding NMTOKEN #IMPLIED
	leftBorder (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	leftBorderColor CDATA #IMPLIED
	leftPadding NMTOKEN #IMPLIED
	bottomBorder (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	bottomBorderColor CDATA #IMPLIED
	bottomPadding NMTOKEN #IMPLIED
	rightBorder (None | Thin | 1Point | 2Point | 4Point | Dotted) #IMPLIED
	rightBorderColor CDATA #IMPLIED
	rightPadding NMTOKEN #IMPLIED
>

<!ELEMENT anchorNameExpression (#PCDATA)>
<!ELEMENT hyperlinkReferenceExpression (#PCDATA)>
<!ELEMENT hyperlinkAnchorExpression (#PCDATA)>
<!ELEMENT hyperlinkPageExpression (#PCDATA)>

<!ELEMENT staticText (reportElement, box?, textElement?, text?)>
<!ELEMENT text (#PCDATA)>

<!ELEMENT textElement (font?)>
<!ATTLIST textElement
	textAlignment (Left | Center | Right | Justified) #IMPLIED
	verticalAlignment (Top | Middle | Bottom) #IMPLIED
	rotation (None | Left | Right) #IMPLIED
	lineSpacing (Single | 1_1_2 | Double) #IMPLIED
	isStyledText (true | false) #IMPLIED
>

<!ELEMENT font EMPTY>
<!ATTLIST font
	reportFont NMTOKEN #IMPLIED
	fontName CDATA #IMPLIED
	size NMTOKEN #IMPLIED
	isBold (true | false) #IMPLIED
	isItalic (true | false) #IMPLIED
	isUnderline (true | false) #IMPLIED
	isStrikeThrough (true | false) #IMPLIED
	pdfFontName CDATA #IMPLIED
	pdfEncoding CDATA #IMPLIED
	isPdfEmbedded (true | false) #IMPLIED
>

<!ELEMENT textField (reportElement, box?, textElement?, textFieldExpression?, anchorNameExpression?, hyperlinkReferenceExpression?, hyperlinkAnchorExpression?, hyperlinkPageExpression?)>
<!ATTLIST textField
	isStretchWithOverflow (true | false) "false"
	evaluationTime (Now | Report | Page | Column | Group | Band | Auto) "Now"
	evaluationGroup CDATA #IMPLIED
	pattern CDATA #IMPLIED
	isBlankWhenNull (true | false) #IMPLIED
	hyperlinkType (None | Reference | LocalAnchor | LocalPage | RemoteAnchor | RemotePage) "None"
	hyperlinkTarget (Self | Blank) "Self"
	bookmarkLevel NMTOKEN "0"
>
<!ELEMENT textFieldExpression (#PCDATA)>
<!ATTLIST textFieldExpression
	class (java.lang.Boolean | java.lang.Byte | java.util.Date | java.sql.Timestamp | java.sql.Time | java.lang.Double | java.lang.Float | java.lang.Integer | java.lang.Long | java.lang.Short | java.math.BigDecimal | java.lang.Number | java.lang.String) "java.lang.String"
>

<!ELEMENT subreport (reportElement, parametersMapExpression?, subreportParameter*, (connectionExpression | dataSourceExpression)?, returnValue*, subreportExpression?)>
<!ATTLIST subreport
	isUsingCache (true | false) #IMPLIED
>
<!ELEMENT parametersMapExpression (#PCDATA)>
<!ELEMENT subreportParameter (subreportParameterExpression?)>
<!ATTLIST subreportParameter
	name NMTOKEN #REQUIRED
>
<!ELEMENT subreportParameterExpression (#PCDATA)>

<!ELEMENT returnValue EMPTY>
<!ATTLIST returnValue
	subreportVariable NMTOKEN #IMPLIED
	toVariable NMTOKEN #IMPLIED
	calculation (Nothing | Count | Sum | Average | Lowest | Highest | StandardDeviation | Variance | First) "Nothing"
	incrementerFactoryClass NMTOKEN #IMPLIED
>

<!ELEMENT connectionExpression (#PCDATA)>
<!ELEMENT dataSourceExpression (#PCDATA)>
<!ELEMENT subreportExpression (#PCDATA)>
<!ATTLIST subreportExpression
	class (java.lang.String | java.io.File | java.net.URL | java.io.InputStream | net.sf.jasperreports.engine.JasperReport | dori.jasper.engine.JasperReport) "java.lang.String"
>

<!ELEMENT elementGroup (line | rectangle | ellipse | image | staticText | textField | subreport | pieChart | pie3DChart | barChart | bar3DChart | xyBarChart | stackedBarChart | stackedBar3DChart| lineChart | xyLineChart | areaChart | xyAreaChart | scatterChart | bubbleChart | timeSeriesChart | highLowChart | candlestickChart | elementGroup | crosstab | frame)*>

<!ELEMENT chart (reportElement, box?, chartTitle?, chartSubtitle?, anchorNameExpression?, hyperlinkReferenceExpression?, hyperlinkAnchorExpression?, hyperlinkPageExpression?)>
<!ATTLIST chart
	isShowLegend (true | false) "true"
	evaluationTime (Now | Report | Page | Column | Group | Band) "Now"
	evaluationGroup CDATA #IMPLIED
	hyperlinkType (None | Reference | LocalAnchor | LocalPage | RemoteAnchor | RemotePage) "None"
	hyperlinkTarget (Self | Blank) "Self"
	bookmarkLevel NMTOKEN "0"
	customizerClass NMTOKEN #IMPLIED
>
<!ELEMENT chartTitle (font?, titleExpression?)>
<!ATTLIST chartTitle
	position (Top | Bottom | Left | Right) "Top"
	color CDATA #IMPLIED
>
<!ELEMENT titleExpression (#PCDATA)>
<!ELEMENT chartSubtitle (font?, subtitleExpression?)>
<!ATTLIST chartSubtitle
	color CDATA #IMPLIED
>
<!ELEMENT subtitleExpression (#PCDATA)>

<!ELEMENT pieChart (chart, pieDataset, piePlot)>
<!ELEMENT pieDataset (dataset?, keyExpression?, valueExpression?, labelExpression?)>
<!ELEMENT keyExpression (#PCDATA)>
<!ELEMENT valueExpression (#PCDATA)>
<!ELEMENT labelExpression (#PCDATA)>
<!ELEMENT piePlot (plot)>

<!ELEMENT dataset (datasetRun?)>
<!ATTLIST dataset
	resetType (None | Report | Page | Column | Group) "Report"
	resetGroup CDATA #IMPLIED
	incrementType (None | Report | Page | Column | Group) "None"
	incrementGroup CDATA #IMPLIED
>

<!ELEMENT datasetRun (parametersMapExpression?, datasetParameter*, (connectionExpression | dataSourceExpression)?)>
<!ATTLIST datasetRun
	subDataset NMTOKEN #REQUIRED
>

<!ELEMENT datasetParameter (datasetParameterExpression?)>
<!ATTLIST datasetParameter
	name NMTOKEN #REQUIRED
>

<!ELEMENT datasetParameterExpression (#PCDATA)>

<!ELEMENT plot EMPTY>
<!ATTLIST plot
	backcolor CDATA #IMPLIED
	orientation (Horizontal | Vertical) "Vertical"
	backgroundAlpha NMTOKEN "1"
	foregroundAlpha NMTOKEN "1"
>

<!ELEMENT pie3DChart (chart, pieDataset, pie3DPlot)>
<!ELEMENT pie3DPlot (plot)>
<!ATTLIST pie3DPlot
	depthFactor CDATA "0.2"
>

<!ELEMENT barChart (chart, categoryDataset, barPlot)>
<!ELEMENT categoryDataset (dataset?, categorySeries*)>
<!ELEMENT categorySeries (seriesExpression?, categoryExpression?, valueExpression?, labelExpression?)>
<!ELEMENT seriesExpression (#PCDATA)>
<!ELEMENT categoryExpression (#PCDATA)>

<!ELEMENT barPlot (plot, categoryAxisLabelExpression?, valueAxisLabelExpression?)>
<!ATTLIST barPlot
	isShowLabels (true | false ) "false"
	isShowTickMarks (true | false) "true"
	isShowTickLabels (true | false) "true"
>
<!ELEMENT categoryAxisLabelExpression (#PCDATA)>
<!ELEMENT valueAxisLabelExpression (#PCDATA)>

<!ELEMENT bar3DChart (chart, categoryDataset, bar3DPlot)>
<!ELEMENT bar3DPlot (plot, categoryAxisLabelExpression?, valueAxisLabelExpression?)>
<!ATTLIST bar3DPlot
	isShowLabels (true | false ) "false"
	xOffset CDATA #IMPLIED
	yOffset CDATA #IMPLIED
>

<!ELEMENT xyBarChart (chart, (timePeriodDataset | timeSeriesDataset | xyDataset ), barPlot)>

<!ELEMENT timePeriodDataset (dataset?, timePeriodSeries*)>
<!ELEMENT timePeriodSeries (seriesExpression?, startDateExpression?, endDateExpression?, valueExpression?, labelExpression?)>
<!ELEMENT startDateExpression (#PCDATA)>
<!ELEMENT endDateExpression (#PCDATA)>

<!ELEMENT stackedBarChart (chart, categoryDataset, barPlot)>

<!ELEMENT stackedBar3DChart (chart, categoryDataset, bar3DPlot)>

<!ELEMENT lineChart (chart, categoryDataset, linePlot)>
<!ELEMENT linePlot (plot, categoryAxisLabelExpression?, valueAxisLabelExpression?)>
<!ATTLIST linePlot
	isShowLines (true | false) "true"
	isShowShapes (true | false) "true"
>

<!ELEMENT xyLineChart (chart, xyDataset, linePlot)>
<!ELEMENT xyDataset (dataset?, xySeries*)>
<!ELEMENT xySeries (seriesExpression?, xValueExpression?, yValueExpression?, labelExpression?)>
<!ELEMENT xValueExpression (#PCDATA)>
<!ELEMENT yValueExpression (#PCDATA)>

<!ELEMENT areaChart (chart, categoryDataset, areaPlot)>
<!ELEMENT areaPlot (plot, categoryAxisLabelExpression?, valueAxisLabelExpression?)>

<!ELEMENT xyAreaChart (chart, xyDataset, areaPlot)>

<!ELEMENT scatterChart (chart, xyDataset, scatterPlot)>
<!ELEMENT scatterPlot (plot, xAxisLabelExpression?, yAxisLabelExpression?)>
<!ATTLIST scatterPlot
	isShowLines (true | false) "true"
	isShowShapes (true | false) "true"
>
<!ELEMENT xAxisLabelExpression (#PCDATA)>
<!ELEMENT yAxisLabelExpression (#PCDATA)>

<!ELEMENT bubbleChart (chart, xyzDataset, bubblePlot)>
<!ELEMENT xyzDataset (dataset?, xyzSeries*)>
<!ELEMENT xyzSeries (seriesExpression?, xValueExpression?, yValueExpression?, zValueExpression?)>
<!ELEMENT bubblePlot (plot, xAxisLabelExpression?, yAxisLabelExpression?)>
<!ATTLIST bubblePlot
	scaleType (BothAxes | DomainAxis | RangeAxis) "RangeAxis"
>
<!ELEMENT zValueExpression (#PCDATA)>

<!ELEMENT timeSeriesDataset (dataset?, timeSeries*)>
<!ATTLIST timeSeriesDataset
	timePeriod (Year | Quarter | Month | Week | Day | Hour | Minute | Second | Milisecond ) "Day"
>
<!ELEMENT timeSeries (seriesExpression?, timePeriodExpression?, valueExpression?, labelExpression?)>
<!ELEMENT timePeriodExpression (#PCDATA)>

<!ELEMENT timeSeriesChart (chart, timeSeriesDataset, timeSeriesPlot)>
<!ELEMENT timeSeriesPlot (plot, timeAxisLabelExpression?, valueAxisLabelExpression?)>
<!ATTLIST timeSeriesPlot
	isShowLines (true | false) "true"
	isShowShapes (true | false) "true"
>
<!ELEMENT timeAxisLabelExpression (#PCDATA)>

<!ELEMENT highLowChart (chart, highLowDataset, highLowPlot)>
<!ELEMENT highLowDataset (dataset?, seriesExpression?, dateExpression?, highExpression?, lowExpression?, openExpression?, closeExpression?, volumeExpression?)>
<!ELEMENT highLowPlot (plot, timeAxisLabelExpression?, valueAxisLabelExpression?)>
<!ATTLIST highLowPlot
	isShowCloseTicks (true | false) "true"
	isShowOpenTicks (true | false) "true"
>
<!ELEMENT dateExpression (#PCDATA)>
<!ELEMENT highExpression (#PCDATA)>
<!ELEMENT lowExpression (#PCDATA)>
<!ELEMENT openExpression (#PCDATA)>
<!ELEMENT closeExpression (#PCDATA)>
<!ELEMENT volumeExpression (#PCDATA)>

<!ELEMENT candlestickChart (chart, highLowDataset, candlestickPlot)>
<!ELEMENT candlestickPlot (plot, timeAxisLabelExpression?, valueAxisLabelExpression?)>
<!ATTLIST candlestickPlot
	isShowVolume (true | false) "true"
>


<!ELEMENT crosstab (reportElement, crosstabParameter*, parametersMapExpression?, crosstabDataset?, crosstabHeaderCell?, rowGroup*, columnGroup*, measure*, crosstabCell*, whenNoDataCell?)>
<!ATTLIST crosstab
	isRepeatColumnHeaders (true | false) "true"
	isRepeatRowHeaders (true | false) "true"
	columnBreakOffset NMTOKEN "10"
>

<!ELEMENT crosstabParameter (parameterValueExpression?)>
<!ATTLIST crosstabParameter
	name CDATA #REQUIRED
	class NMTOKEN "java.lang.String"
>

<!ELEMENT parameterValueExpression (#PCDATA)>

<!ELEMENT crosstabDataset (dataset?)>
<!ATTLIST crosstabDataset
	isDataPreSorted (true | false) "false"
>

<!ELEMENT crosstabHeaderCell (cellContents)>

<!ELEMENT rowGroup (bucket, crosstabRowHeader?, crosstabTotalRowHeader?)>
<!ATTLIST rowGroup
	name NMTOKEN #REQUIRED
	width NMTOKEN #REQUIRED
	totalPosition (Start | End | None) "None"
	headerPosition (Top | Middle | Bottom | Stretch) "Top"
>

<!ELEMENT crosstabRowHeader (cellContents?)>

<!ELEMENT crosstabTotalRowHeader (cellContents?)>

<!ELEMENT columnGroup (bucket, crosstabColumnHeader?, crosstabTotalColumnHeader?)>
<!ATTLIST columnGroup
	name NMTOKEN #REQUIRED
	height NMTOKEN #REQUIRED
	totalPosition (Start | End | None) "None"
	headerPosition (Left | Center | Right | Stretch) "Left"
>

<!ELEMENT crosstabColumnHeader (cellContents?)>

<!ELEMENT crosstabTotalColumnHeader (cellContents?)>

<!ELEMENT bucket (bucketExpression, comparatorExpression?)>
<!ATTLIST bucket
	order (Ascending | Descending) "Ascending"
>

<!ELEMENT bucketExpression (#PCDATA)>
<!ATTLIST bucketExpression
	class NMTOKEN #REQUIRED
>

<!ELEMENT comparatorExpression (#PCDATA)>

<!ELEMENT measure (measureExpression)>
<!ATTLIST measure
	name NMTOKEN #REQUIRED
	class NMTOKEN #REQUIRED
	calculation (Nothing | Count | Sum | Average | Lowest | Highest | StandardDeviation | Variance | First) "Nothing"
	incrementerFactoryClass NMTOKEN #IMPLIED
	percentageOf (None | GrandTotal) "None"
	percentageCalculatorClass NMTOKEN #IMPLIED
>

<!ELEMENT measureExpression (#PCDATA)>

<!ELEMENT crosstabCell (cellContents?)>
<!ATTLIST crosstabCell
	width NMTOKEN #IMPLIED
	height NMTOKEN #IMPLIED
	rowTotalGroup NMTOKEN #IMPLIED
	columnTotalGroup NMTOKEN #IMPLIED
>

<!ELEMENT cellContents (box?, (line | rectangle | ellipse | image | staticText | textField | elementGroup | frame)*)>
<!ATTLIST cellContents
	backcolor CDATA #IMPLIED
	mode (Opaque | Transparent) #IMPLIED
	style NMTOKEN #IMPLIED
>

<!ELEMENT whenNoDataCell (cellContents)>

<!ELEMENT frame (reportElement, box?, (line | rectangle | ellipse | image | staticText | textField | subreport | pieChart | pie3DChart | barChart | bar3DChart | xyBarChart | stackedBarChart | stackedBar3DChart| lineChart | xyLineChart | areaChart | xyAreaChart | scatterChart | bubbleChart | timeSeriesChart | highLowChart | candlestickChart | elementGroup | crosstab | frame)*)>

 *
 */
public class ReportBase implements Serializable {
	
	public ReportBase() {
		
	}

}
