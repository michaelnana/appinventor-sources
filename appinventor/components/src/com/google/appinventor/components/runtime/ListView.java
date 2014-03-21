package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.util.TextViewUtil;
import com.google.appinventor.components.runtime.util.YailList;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.*;

/**
 * Sensor that can measure absolute orientation in 3 dimensions.
 *
 */
@DesignerComponent(version = 1, //This should be a reference to YaVersion.java
    description = "<p>This is a visible component that allows you to place a list in your view display a list of strings that you decide to set<br>" +
        "You can set the list using ElementsFromString or you can use the Elements blocks in the blocks editor. </p>",
    category = ComponentCategory.USERINTERFACE,
    nonVisible = false,
    iconName = "images/listView.png")

@SimpleObject
public final class ListView extends AndroidViewComponent {
  private final android.widget.ListView view;
  //private final LinearLayout lay;
//private final android.widget.ListView listView;
  ArrayAdapter<String> adapter;
  //private final TextView txt;

  // Backing for text alignment
  private int textAlignment;

  // Backing for background color
  private int backgroundColor;

  // Backing for font typeface
  private int fontTypeface;

  // Backing for font bold
  private boolean bold;

  // Backing for font italic
  private boolean italic;

  // Backing for text color
  private int textColor;

  String[] items;
  ArrayList listItems;
  int index=0;

  /**
   * Creates a new ListView component.
   *
   * @param container  container, component will be placed in
   */
  public ListView(ComponentContainer container) {
    super(container);
    view = new android.widget.ListView(container.$context());
    listItems=new ArrayList();

    // Default property values
    //TextAlignment(Component.ALIGNMENT_NORMAL);
    fontTypeface = Component.TYPEFACE_DEFAULT;
   // TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
    //FontSize(Component.FONT_DEFAULT_SIZE);
    ElementsFromString("");
    //TextColor(Component.COLOR_BLACK);
    //CustomAdapter ad=new CustomAdapter(container.$context(),items,it, it);
    adapter = new ArrayAdapter<String>(container.$context(), android.R.layout.simple_list_item_1, items);
    view.setAdapter(adapter);
    view.setBackgroundColor(COLOR_BLACK);
    //view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
    container.$add(this);
    Width(LENGTH_PREFERRED);
    //Height(LENGTH_PREFERRED);
  }

  @Override
  public View getView() {
    return view;
  }

  public void setList(){
    adapter = new ArrayAdapter<String>(container.$context(), android.R.layout.simple_list_item_1, items);
    view.setAdapter(adapter);
  }

  /**
   * Returns the alignment of the listview's text: center, normal
   * (e.g., left-justified if text is written left to right), or
   * opposite (e.g., right-justified if text is written left to right).
   *
   * @return  one of {@link Component#ALIGNMENT_NORMAL},
   *          {@link Component#ALIGNMENT_CENTER} or
   *          {@link Component#ALIGNMENT_OPPOSITE}
   */
  /*@SimpleProperty(
      category = PropertyCategory.APPEARANCE,
      userVisible = false)
  public int TextAlignment() {
    return textAlignment;
  }*/

  @Override
  @SimpleProperty()
  public void Height(int height) {
    if (height == LENGTH_PREFERRED) {
      height = LENGTH_FILL_PARENT;
    }
    super.Height(height);
  }

  @Override
  @SimpleProperty()
  public void Width(int width) {
    if (width == LENGTH_PREFERRED) {
      width = LENGTH_FILL_PARENT;
    }
    super.Width(width);
  }

  /**
   * Specifies the alignment of the label's text: center, normal
   * (e.g., left-justified if text is written left to right), or
   * opposite (e.g., right-justified if text is written left to right).
   *
   * @param alignment  one of {@link Component#ALIGNMENT_NORMAL},
   *                   {@link Component#ALIGNMENT_CENTER} or
   *                   {@link Component#ALIGNMENT_OPPOSITE}
   */
  /*@DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_TEXTALIGNMENT,
      defaultValue = Component.ALIGNMENT_NORMAL + "")
  @SimpleProperty(
      userVisible = false)
  public void TextAlignment(int alignment) {
    this.textAlignment = alignment;
    //TextViewUtil.setAlignment(view, alignment, false);
    //TextViewUtil.setAlignment(view, alignment, false);
  }*/

  /**
   * Returns the listview's background color as an alpha-red-green-blue
   * integer.
   *
   * @return  background RGB color with alpha
   */
  /*@SimpleProperty(
      category = PropertyCategory.APPEARANCE)
  public int BackgroundColor() {
    return backgroundColor;
  }*/

  /**
   * Specifies the listview's background color as an alpha-red-green-blue
   * integer.
   *
   * @param argb  background RGB color with alpha
   */
  /*@DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
      defaultValue = Component.DEFAULT_VALUE_COLOR_NONE)
  @SimpleProperty
  public void BackgroundColor(int argb) {
    backgroundColor = argb;

   /*f (argb != Component.COLOR_DEFAULT) {
      TextViewUtil.setBackgroundColor(view, argb);
    } else {
      TextViewUtil.setBackgroundColor(view, Component.COLOR_NONE);
    }*/
  //}

  /**
   * Returns true if the label's text should be bold.
   * If bold has been requested, this property will return true, even if the
   * font does not support bold.
   *
   * @return  {@code true} indicates bold, {@code false} normal
   */
 /* @SimpleProperty(
      category = PropertyCategory.APPEARANCE,
      userVisible = false)
  public boolean FontBold() {
    return bold;
  }*/

  /**
   * Specifies whether the label's text should be bold.
   * Some fonts do not support bold.
   *
   * @param bold  {@code true} indicates bold, {@code false} normal
   */
  /*@DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
      defaultValue = "False")
  @SimpleProperty(
      userVisible = false)
  public void FontBold(boolean bold) {
    this.bold = bold;
   // TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
  }*/

  /**
   * Returns true if the label's text should be italic.
   * If italic has been requested, this property will return true, even if the
   * font does not support italic.
   *
   * @return  {@code true} indicates italic, {@code false} normal
   */
 /* @SimpleProperty(
      category = PropertyCategory.APPEARANCE,
      userVisible = false)
  public boolean FontItalic() {
    return italic;
  }*/

  /**
   * Specifies whether the label's text should be italic.
   * Some fonts do not support italic.
   *
   * @param italic  {@code true} indicates italic, {@code false} normal
   */
  /*@DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
      defaultValue = "False")
  @SimpleProperty(
      userVisible = false)
  public void FontItalic(boolean italic) {
    this.italic = italic;
    //TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
  }*/

  /**
   * Returns the label's text's font size, measured in pixels.
   *
   * @return  font size in pixel
   */
 /* @SimpleProperty(
      category = PropertyCategory.APPEARANCE)
  public float FontSize() {
    return 10;//TextViewUtil.getFontSize(view);
  }*/

  /**
   * Specifies the label's text's font size, measured in pixels.
   *
   * @param size  font size in pixel
   */
  /*@DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_FLOAT,
      defaultValue = Component.FONT_DEFAULT_SIZE + "")
  @SimpleProperty
  public void FontSize(float size) {
    //TextViewUtil.setFontSize(view, size);
  }*/

  /**
   * Returns the label's text's font face as default, serif, sans
   * serif, or monospace.
   *
   * @return  one of {@link Component#TYPEFACE_DEFAULT},
   *          {@link Component#TYPEFACE_SERIF},
   *          {@link Component#TYPEFACE_SANSSERIF} or
   *          {@link Component#TYPEFACE_MONOSPACE}
   */
 /* @SimpleProperty(
      category = PropertyCategory.APPEARANCE,
      userVisible = false)
  public int FontTypeface() {
    return fontTypeface;
  }*/

  /**
   * Specifies the label's text's font face as default, serif, sans
   * serif, or monospace.
   *
   * @param typeface  one of {@link Component#TYPEFACE_DEFAULT},
   *                  {@link Component#TYPEFACE_SERIF},
   *                  {@link Component#TYPEFACE_SANSSERIF} or
   *                  {@link Component#TYPEFACE_MONOSPACE}
   */
 /* @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_TYPEFACE,
      defaultValue = Component.TYPEFACE_DEFAULT + "")
  @SimpleProperty(
      userVisible = false)
  public void FontTypeface(int typeface) {
    fontTypeface = typeface;
   // TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
  }*/

  /**
   * Returns the text displayed by the label.
   *
   * @return  label caption
   */
  /*@SimpleProperty(
      category = PropertyCategory.APPEARANCE)
  public String ElementsFromString() {
    //return TextViewUtil.getText(view);
    return "Hey";
  }*/

  /**
   * Specifies the String elements you want to add to the listview.
   *
   * @param text  new caption for label
   */
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
      defaultValue = "")
  @SimpleProperty
  public void ElementsFromString(String text) {
    items=text.split(", ");
    setList();
    //TextViewUtil.setText(view, text);
  }

  @SimpleProperty
  public void Elements(YailList text) {
    items=text.toStringArray();
    setList();
    //TextViewUtil.setText(view, text);
  }

  @SimpleProperty
  public void SelectionIndex(int i){
    index=i-1;
  }

  @SimpleProperty
  public String Selection(){
      return items[index];
  }

  /**
   * Returns the label's text color as an alpha-red-green-blue
   * integer.
   *
   * @return  text RGB color with alpha
   */
  /*@SimpleProperty(
      category = PropertyCategory.APPEARANCE)
  public int TextColor() {
    return textColor;
  }*/

  /**
   * Specifies the label's text color as an alpha-red-green-blue
   * integer.
   *
   * @param argb  text RGB color with alpha
   */
  /*@DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
      defaultValue = Component.DEFAULT_VALUE_COLOR_BLACK)
  @SimpleProperty
  public void TextColor(int argb) {
    textColor = argb;
   /* if (argb != Component.COLOR_DEFAULT) {
      TextViewUtil.setTextColor(view, argb);
    } else {
      TextViewUtil.setTextColor(view, Component.COLOR_BLACK);
    }*/
  //}
}