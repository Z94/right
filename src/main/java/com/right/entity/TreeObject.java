package com.right.entity;

import java.util.Vector;

public class TreeObject
{
  public boolean isRight = false;
  public boolean isVisible = false;
  public int type;
  public int id;
  public int upid;
  public int rank_order;
  public String name = "";
  public String url = "";
  public String target = "";

  public TreeObject parentNode = null;
  protected Vector vc;
  public static final int NODE = 1;
  public static final int LEAF = 2;

  public void addChild(TreeObject paramTreeObject)
  {
    if (this.vc == null)
      this.vc = new Vector();
    this.vc.addElement(paramTreeObject);
  }
  public int getChildSize() {
    if (this.vc == null)
    {
      return 0;
    }

    return this.vc.size();
  }
  public TreeObject[] getChild() {
    if (this.vc == null)
    {
      return null;
    }

    Object[] arrayOfObject = this.vc.toArray();
    TreeObject[] arrayOfTreeObject = new TreeObject[arrayOfObject.length];
    for (int i = 0; i < arrayOfObject.length; i++)
    {
      arrayOfTreeObject[i] = ((TreeObject)arrayOfObject[i]);
    }
    return arrayOfTreeObject;
  }

  public Vector getChildInVector() {
    return this.vc;
  }
}