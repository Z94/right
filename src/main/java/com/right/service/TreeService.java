package com.right.service;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.right.dao.OrgMapper;
import com.right.dao.RoleMapper;
import com.right.dao.UserFunMapper;
import com.right.dao.UserModuleMapper;
import com.right.dao.UserRoleMapper;
import com.right.dao.CommonMapper;
import com.right.dao.FManagerMapper;
import com.right.dao.FunctionMapper;
import com.right.dao.MManagerMapper;
import com.right.dao.ManagerMapper;
import com.right.dao.ModuleMapper;
import com.right.entity.Org;
import com.right.entity.TreeObject;

@Service
public class TreeService {
	  private static int rootNextId = -100;
	  private static int offsetId = 0;

	  private boolean isRightTree = false;
	  protected String nodeTableSql;
	  protected String leafTableSql;
	  protected String nodeDefaultUrl = ""; protected String leafDefaultUrl = "";
	  protected int nodeIndex;
	  protected int upNodeIndex;
	  protected int nodeNameIndex;
	  protected int nodeUrlIndex = -1;
	  protected int nodeOrder;
	  protected int nodeTargetIndex;
	  protected int nodeRightControlMarkIndex;
	  protected int leafIndex;
	  protected int parentNodeIndex;
	  protected int leafNameIndex;
	  protected int leafUrlIndex = -1;
	  protected int leafOrder;
	  protected int leafTargetIndex;
	  protected int leafRightControlMarkIndex;
	  protected String roleRightSql;
	  protected String leafRightSql;
	  protected String nodeRightSql;
	  protected int nodeConstrictIndex;
	  protected int leafConstrictIndex;
	  protected int roleConstrictIndex;
	  public TreeObject[] treeObjectArrayReconstruct;
	  private TreeObject[] treeObjectArray;
	  protected int nodeLen = 0; protected int leafLen = 0;

	  protected int treeDepth = 0;

	  boolean AllRight = false;

	  public String leafImage = "treeImage/img-page.gif";
	  public String nodeOpenImage = "treeImage/img-folder-open.gif";
	  public String nodeCloseImage = "treeImage/img-folder.gif";
	  public String midPlusImage = "treeImage/img-plus-end.gif";
	  public String midMinusImage = "treeImage/img-minus-end.gif";
	  private StringBuffer buf;
	  private final String CR = " \n ";
	  int i;

	  HttpSession session;
	  public static int getNextInt()
	  {
	    rootNextId -= 1;
	    return rootNextId;
	  }
	  private static TreeObject makeSpecialNode(String paramString1, String paramString2, String paramString3) {
	    TreeObject localTreeObject = new TreeObject();
	    localTreeObject.type = 1;
	    localTreeObject.id = getNextInt();
	    localTreeObject.upid = -1;
	    localTreeObject.name = paramString1;
	    localTreeObject.url = paramString2;
	    localTreeObject.target = paramString3;
	    localTreeObject.isRight = true;
	    return localTreeObject;
	  }
	  public boolean addRootToCurrentTree(String paramString1, String paramString2, String paramString3) {
	    return addRootToCurrentTree(makeSpecialNode(paramString1, paramString2, paramString3));
	  }

	  private boolean hasCondition() {
	    if ((this.nodeIndex > -1) && (this.upNodeIndex > -1) && (this.nodeNameIndex > -1) && (this.nodeOrder > -1) && (this.leafIndex > -1) && (this.parentNodeIndex > -1) && (this.leafNameIndex > -1) && (this.leafOrder > -1))
	    {
	      return true;
	    }

	    return false;
	  }

	  private boolean addRootToCurrentTree(TreeObject paramTreeObject)
	  {
	    if (paramTreeObject == null)
	    {
	      return false;
	    }
	    if ((this.treeObjectArrayReconstruct == null) || (this.treeObjectArrayReconstruct.length == 0))
	    {
	      this.treeObjectArrayReconstruct = new TreeObject[1];
	      this.treeObjectArrayReconstruct[0] = paramTreeObject;
	      return true;
	    }

	    TreeObject localTreeObject = this.treeObjectArrayReconstruct[0];
	    paramTreeObject.addChild(localTreeObject);
	    localTreeObject.parentNode = paramTreeObject;

	    TreeObject[] arrayOfTreeObject = new TreeObject[this.treeObjectArrayReconstruct.length + 1];
	    arrayOfTreeObject[0] = paramTreeObject;

	    for (int i = 0; i < this.treeObjectArrayReconstruct.length; i++)
	    {
	      arrayOfTreeObject[(i + 1)] = this.treeObjectArrayReconstruct[i];
	    }

	    this.treeObjectArrayReconstruct = arrayOfTreeObject;
	    arrayOfTreeObject = null;
	    return true;
	  }

	  public boolean addSubRootToCurrentTree(TreeObject[] paramArrayOfTreeObject, int paramInt)
	  {
	    if ((paramArrayOfTreeObject == null) || (paramArrayOfTreeObject.length == 0) || (paramInt < 0) || (paramInt >= paramArrayOfTreeObject.length))
	    {
	      return false;
	    }
	    if ((this.treeObjectArrayReconstruct == null) || (this.treeObjectArrayReconstruct.length == 0))
	    {
	      this.treeObjectArrayReconstruct = paramArrayOfTreeObject;
	      return true;
	    }

	    TreeObject localTreeObject1 = this.treeObjectArrayReconstruct[0];
	    TreeObject localTreeObject2 = paramArrayOfTreeObject[paramInt];
	    localTreeObject1.addChild(localTreeObject2);
	    localTreeObject2.parentNode = localTreeObject1;

	    TreeObject[] arrayOfTreeObject = new TreeObject[this.treeObjectArrayReconstruct.length + paramArrayOfTreeObject.length - paramInt];
	    for (int i = 0; i < this.treeObjectArrayReconstruct.length; i++)
	    {
	      arrayOfTreeObject[i] = this.treeObjectArrayReconstruct[i];
	    }
	    for (i = this.treeObjectArrayReconstruct.length; i < this.treeObjectArrayReconstruct.length + paramArrayOfTreeObject.length - paramInt; i++)
	    {
	      arrayOfTreeObject[i] = paramArrayOfTreeObject[(i - this.treeObjectArrayReconstruct.length + paramInt)];
	    }
	    this.treeObjectArrayReconstruct = arrayOfTreeObject;
	    arrayOfTreeObject = null;
	    return true;
	  }

	  public void makeTree(String userType,String userId) {
	    makeTree("",userType,userId);
	  }
	  private String dealEmptyStr(String paramString) {
	    if (paramString.equals(""))
	    {
	      paramString = "0";
	    }
	    return paramString;
	  }

	  public void makeTree(String paramString,String userType,String userId) {
	    System.out.println("1:hasCondition()" + hasCondition());
	    if (!hasCondition()) return;
	    System.out.println("2:hasCondition()" + hasCondition());
	    try
	    {
//	      exeQueryResult localexeQueryResult = new exeQueryResult();

	      System.out.println("------------------------------------------------------0");
//	      String[][] arrayOfString1 = localexeQueryResult.getSelectResultWithStringArray(this.nodeTableSql);
	      String[][] arrayOfString1 = (String[][])null;
	      String[][] arrayOfString2 = (String[][])null;
	      if (paramString.equals("")) {

		      arrayOfString1 = getArray1(userType);
		}else {
			arrayOfString1 = getArray6();
		}

	      if (this.leafTableSql != null)
	      {
	        System.out.println("-----" + this.leafTableSql);
//	        arrayOfString2 = localexeQueryResult.getSelectResultWithStringArray(this.leafTableSql);
	        if (paramString.equals("")) {
		        arrayOfString2 = getArray2(userType);
			}else {
				arrayOfString2 = getArray7();
			}
	        if (arrayOfString2 != null)
	        {
	          this.leafLen = arrayOfString2.length;
	        }
	        System.out.println("leafLen" + arrayOfString2[0].length);
	      }
	      if (arrayOfString1 == null)
	      {
	        return;
	      }
	      if (arrayOfString1.length == 0)
	      {
	        return;
	      }
	      this.nodeLen = arrayOfString1.length;
	      this.treeObjectArray = new TreeObject[this.nodeLen + this.leafLen];
	      TreeObject localTreeObject1;
	      for (int i = 0; i < arrayOfString1.length; i++) {
	        try {
	          localTreeObject1 = new TreeObject();
	          localTreeObject1.type = 1;
	          System.out.println("adasdas"+arrayOfString1[i][this.nodeIndex]);
	          localTreeObject1.id = (Integer.parseInt((arrayOfString1[i][this.nodeIndex])) + offsetId);
	          if (i > 0)
	          {
	            localTreeObject1.upid = (Integer.parseInt((arrayOfString1[i][this.upNodeIndex])) + offsetId);
	          }
	          else
	            localTreeObject1.upid = (-1 + offsetId);
	          localTreeObject1.name = arrayOfString1[i][this.nodeNameIndex].trim();
	          if (!arrayOfString1[i][this.nodeOrder].equals(""))
	          {
	        	  System.out.println("order                  "+this.nodeOrder);
	            localTreeObject1.rank_order = Integer.parseInt((arrayOfString1[i][this.nodeOrder]));//this.nodeOrder
	          }
	          else
	          {
	            localTreeObject1.rank_order = 0;
	          }

	          localTreeObject1.url = (this.nodeUrlIndex > -1 ? arrayOfString1[i][this.nodeUrlIndex] : this.nodeDefaultUrl);
	          localTreeObject1.url = localTreeObject1.url.trim();
	          localTreeObject1.target = (this.nodeTargetIndex > -1 ? arrayOfString1[i][this.nodeTargetIndex] : "");
	          localTreeObject1.target = localTreeObject1.target.trim();

	          if (this.nodeRightControlMarkIndex > -1)
	          {
	            if ((arrayOfString1[i][this.nodeRightControlMarkIndex]).equals("0"))
	            {
	              localTreeObject1.isRight = true;
	            }

	          }

	          if (this.AllRight)
	          {
	            localTreeObject1.isRight = true;
	          }
	          this.treeObjectArray[i] = localTreeObject1;
	        }
	        catch (Exception localException2)
	        {
	          localException2.printStackTrace();
	        }

	      }

	      for (i = 1; i < this.nodeLen; i++) {
	        localTreeObject1 = this.treeObjectArray[i];
	        for (int k = 0; k < this.nodeLen; k++)
	          if (localTreeObject1.upid == this.treeObjectArray[k].id)
	          {
	            this.treeObjectArray[k].addChild(localTreeObject1);
	            localTreeObject1.parentNode = this.treeObjectArray[k];
	            break;
	          }
	      }
	      int m;
	      if (arrayOfString2 != null)
	      {
	        for (i = this.nodeLen; i < this.treeObjectArray.length; i++) {
	          try {
	            localTreeObject1 = new TreeObject();
	            localTreeObject1.type = 2;
	            localTreeObject1.id = (Integer.parseInt((arrayOfString2[(i - this.nodeLen)][this.leafIndex])) + offsetId);

	            localTreeObject1.upid = (Integer.parseInt((arrayOfString2[(i - this.nodeLen)][this.parentNodeIndex])) + offsetId);

	            localTreeObject1.name = arrayOfString2[(i - this.nodeLen)][this.leafNameIndex].trim();
	            if (!arrayOfString2[(i - this.nodeLen)][this.leafOrder].equals(""))
	            {
	              localTreeObject1.rank_order = Integer.parseInt((arrayOfString2[(i - this.nodeLen)][this.leafOrder]));
	            }
	            else {
	              localTreeObject1.rank_order = 0;
	            }

	            localTreeObject1.url = (this.leafUrlIndex > -1 ? arrayOfString2[(i - this.nodeLen)][this.leafUrlIndex] : this.leafDefaultUrl);
	            localTreeObject1.url = localTreeObject1.url.trim();

	            localTreeObject1.target = (this.leafTargetIndex > -1 ? arrayOfString2[(i - this.nodeLen)][this.leafTargetIndex] : "");

	            localTreeObject1.target = localTreeObject1.target.trim();

	            if (this.leafRightControlMarkIndex > -1)
	            {
	              if ((arrayOfString2[(i - this.nodeLen)][this.leafRightControlMarkIndex]).equals("0"))
	              {
	                localTreeObject1.isRight = true;
	              }
	            }

	            if (this.AllRight)
	            {
	              localTreeObject1.isRight = true;
	            }
	            this.treeObjectArray[i] = localTreeObject1;
	          }
	          catch (Exception localException3)
	          {
	            localException3.printStackTrace();
	          }
	        }

	        for (i = this.nodeLen; i < this.treeObjectArray.length; i++) {
	          localTreeObject1 = this.treeObjectArray[i];
	          for (m = 0; m < this.nodeLen; m++) {
	            if (localTreeObject1.upid == this.treeObjectArray[m].id) {
	              this.treeObjectArray[m].addChild(localTreeObject1);
	              localTreeObject1.parentNode = this.treeObjectArray[m];
	              break;
	            }
	          }

	        }

	      }

	      if (this.isRightTree)
	      {
	        for (i = 0; i < this.treeObjectArray.length; i++)
	        {
	          if ((this.treeObjectArray[i].type == 1) && (this.treeObjectArray[i].isRight == true))
	          {
	            markParentRight(this.treeObjectArray[i]);
	            markSonRight(this.treeObjectArray[i]);
	          }
	          else if ((this.treeObjectArray[i].type == 2) && (this.treeObjectArray[i].isRight == true))
	          {
	            markParentRight(this.treeObjectArray[i]);
	          }

	        }

	        if (this.nodeRightSql != null)
	        {
	          assignNodeRight(offsetId,userType,userId);
	        }
	        if (this.leafRightSql != null) {
	          assignLeafRight(offsetId,userType,userId);
	        }
	        if (this.roleRightSql != null)
	        {
	          assignRoleRight(offsetId,userType,userId);
	        }

	      }
	      else
	      {
	        markSonRight(this.treeObjectArray[0]);
	      }

	      sort(getRoot(true));

	      if (paramString.equals(""))
	      {
	        addSubRootToCurrentTree(this.treeObjectArray, 0);
	      }
	      else {
	        TreeObject localTreeObject2 = getByName(paramString, true);

	        if (localTreeObject2 == null)
	        {
	          m = 0;
	        }
	        else {
	          m = findIndex(localTreeObject2, true);
	        }

	        addSubRootToCurrentTree(this.treeObjectArray, m);
	      }

	      for (int j = 0; j < this.treeObjectArray.length; j++)
	      {
	        if (this.treeObjectArray[j].getChildSize() == 0)
	        {
	          this.treeObjectArray[j].type = 2;
	        }

	      }

	      tranversTree(this.treeObjectArray[0]);

	      this.nodeIndex = -1;
	      this.upNodeIndex = -1;
	      this.nodeNameIndex = -1;
	      this.nodeOrder = -1;
	      this.nodeUrlIndex = -1;
	      this.nodeDefaultUrl = "";
	      this.nodeTargetIndex = -1;
	      this.nodeRightControlMarkIndex = -1;
	      this.leafIndex = -1;
	      this.parentNodeIndex = -1;
	      this.leafNameIndex = -1;
	      this.leafOrder = -1;
	      this.leafDefaultUrl = "";
	      this.leafTargetIndex = -1;
	      this.leafRightControlMarkIndex = -1;
	      this.isRightTree = false;
	    }
	    catch (Exception localException1)
	    {
	      localException1.printStackTrace();
	    }
	  }

	  private void tranversTree(TreeObject paramTreeObject) { offsetId += 1;
	    if (paramTreeObject.getChildSize() > 0)
	    {
	      TreeObject[] arrayOfTreeObject = paramTreeObject.getChild();

	      for (int i = 0; i < arrayOfTreeObject.length; i++)
	      {
	        tranversTree(arrayOfTreeObject[i]);
	      }
	    } }

	  private void assignRoleRight(int paramInt,String userType,String id)
	  {
//	    exeQueryResult localexeQueryResult = new exeQueryResult();
//	    String[][] arrayOfString = localexeQueryResult.getSelectResultWithStringArray(this.roleRightSql);
	  String[][] arrayOfString = getArray5(id);
		  if ((arrayOfString == null) || (this.nodeLen == 0))
	    {
	      return;
	    }

	    String str2 = this.nodeRightSql;
	    String str3 = this.leafRightSql;
	    for (int i = 0; i < arrayOfString.length; i++)
	    {
	      String str1 = arrayOfString[i][this.roleConstrictIndex];
	      if (!str1.equals(""))
	      {
	        this.nodeRightSql = ("select module_id from D_R_ROLE_MODULE where role_id=' " + str1 + "'");
	        this.nodeConstrictIndex = 0;
	        assignNodeRight(paramInt,userType,id);
	        this.leafRightSql = ("select function_id from D_R_ROLE_FUN where role_id=' " + str1 + "'");
	        this.leafConstrictIndex = 0;
	        assignLeafRight(paramInt,userType,id);
	      }
	    }
	    this.nodeRightSql = str2;
	    this.leafRightSql = str3;
	  }
	  private void assignNodeRight(int paramInt, String userType,String id) {
//	    exeQueryResult localexeQueryResult = new exeQueryResult();
//	    String[][] arrayOfString = localexeQueryResult.getSelectResultWithStringArray(this.nodeRightSql);
		  String[][] arrayOfString = getArray3(userType,id);
		  if ((arrayOfString == null) || (this.nodeLen == 0))
	    {
	      return;
	    }

	    for (int j = 0; j < arrayOfString.length; j++)
	    {
	      String str = arrayOfString[j][this.nodeConstrictIndex];
	      if (!str.equals(""))
	        try
	        {
	          int i = Integer.parseInt((str)) + paramInt;
	          for (int k = 0; k < this.nodeLen; k++)
	          {
	            if (i == this.treeObjectArray[k].id)
	            {
	              markParentRight(this.treeObjectArray[k]);
	              markSonRight(this.treeObjectArray[k]);
	            }
	          }
	        }
	        catch (Exception localException)
	        {
	        }
	    }
	  }

	  private void assignLeafRight(int paramInt,String userType,String id) {
//	    exeQueryResult localexeQueryResult = new exeQueryResult();
//	    String[][] arrayOfString = localexeQueryResult.getSelectResultWithStringArray(this.leafRightSql);
		  String[][] arrayOfString = getArray4(userType,id);
		  if ((arrayOfString == null) || (this.leafLen == 0))
	    {
	      return;
	    }

	    for (int j = 0; j < arrayOfString.length; j++)
	    {
	      String str = arrayOfString[j][this.leafConstrictIndex];
	      if (!str.equals(""))
	        try
	        {
	          int i = Integer.parseInt((str)) + paramInt;
	          for (int k = this.nodeLen; k < this.treeObjectArray.length; k++)
	          {
	            if (i == this.treeObjectArray[k].id)
	            {
	              markParentRight(this.treeObjectArray[k]);
	            }
	          }
	        }
	        catch (Exception localException)
	        {
	        }
	    }
	  }

	  private void markParentRight(TreeObject paramTreeObject) {
	    if (!paramTreeObject.isRight)
	    {
	      paramTreeObject.isRight = true;
	    }

	    if (paramTreeObject.parentNode != null)
	    {
	      markParentRight(paramTreeObject.parentNode);
	    }
	  }

	  private void markSonRight(TreeObject paramTreeObject) { paramTreeObject.isRight = true;

	    if (paramTreeObject.getChildSize() > 0)
	    {
	      TreeObject[] arrayOfTreeObject = paramTreeObject.getChild();

	      for (int i = 0; i < arrayOfTreeObject.length; i++)
	      {
	        if (!arrayOfTreeObject[i].isRight)
	        {
	          markSonRight(arrayOfTreeObject[i]);
	        }
	      }
	    } }

	  private void bubbleSort(Vector paramVector)
	  {
	    int i = 1; int j = paramVector.size() - 1;
	    while ((j > 0) && (i == 1))
	    {
	      i = 0;
	      for (int k = 0; k < j; k++)
	      {
	        TreeObject localTreeObject1 = (TreeObject)paramVector.elementAt(k);
	        TreeObject localTreeObject2 = (TreeObject)paramVector.elementAt(k + 1);
	        if (localTreeObject1.rank_order > localTreeObject2.rank_order)
	        {
	          paramVector.setElementAt(localTreeObject1, k + 1);
	          paramVector.setElementAt(localTreeObject2, k);
	          i = 1;
	        }
	      }
	      j -= 1;
	    }
	  }

	  private void sort(TreeObject paramTreeObject) { if (paramTreeObject.getChildSize() > 0) {
	      bubbleSort(paramTreeObject.getChildInVector());
	      TreeObject[] arrayOfTreeObject = paramTreeObject.getChild();
	      for (int i = 0; i < arrayOfTreeObject.length; i++)
	      {
	        sort(arrayOfTreeObject[i]);
	      }
	    } }

	  public void setNodeConditon(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, int paramInt7)
	  {
	    this.nodeTableSql = paramString1;
	    this.nodeIndex = paramInt1;
	    this.upNodeIndex = paramInt2;
	    this.nodeNameIndex = paramInt3;
	    this.nodeOrder = paramInt4;
	    this.nodeUrlIndex = paramInt5;
	    this.nodeDefaultUrl = paramString2;
	    this.nodeTargetIndex = paramInt6;
	    this.nodeRightControlMarkIndex = paramInt7;
	  }
	  public void setLeafCondition(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, int paramInt7) {
	    this.leafTableSql = paramString1;
	    this.leafIndex = paramInt1;
	    this.parentNodeIndex = paramInt2;
	    this.leafNameIndex = paramInt3;
	    this.leafOrder = paramInt4;
	    this.leafUrlIndex = paramInt5;
	    this.leafDefaultUrl = paramString2;
	    this.leafTargetIndex = paramInt6;
	    this.leafRightControlMarkIndex = paramInt7;
	  }
	  public void setNodeRight(String paramString, int paramInt) {
	    this.nodeRightSql = paramString;
	    this.nodeConstrictIndex = paramInt;
	    this.isRightTree = true;
	  }
	  public void setLeafRight(String paramString, int paramInt) {
	    this.leafRightSql = paramString;
	    this.leafConstrictIndex = paramInt;
	    this.isRightTree = true;
	  }
	  public void setRoleRight(String paramString, int paramInt) {
	    this.roleRightSql = paramString;
	    this.roleConstrictIndex = paramInt;
	    this.isRightTree = true;
	  }

	  public void setAllRight(boolean paramBoolean)
	  {
	    this.AllRight = paramBoolean;
	  }
	  public TreeObject getByIndex(int paramInt, boolean paramBoolean) {
	    Object localObject = null;
	    TreeObject[] arrayOfTreeObject;
	    if (paramBoolean)
	    {
	      arrayOfTreeObject = this.treeObjectArray;
	    }
	    else {
	      arrayOfTreeObject = this.treeObjectArrayReconstruct;
	    }
	    if ((paramInt < 0) || (paramInt > arrayOfTreeObject.length))
	    {
	      return null;
	    }
	    return arrayOfTreeObject[paramInt];
	  }
	  public int findIndex(TreeObject paramTreeObject, boolean paramBoolean) {
	    Object localObject = null;
	    TreeObject[] arrayOfTreeObject;
	    if (paramBoolean)
	    {
	      arrayOfTreeObject = this.treeObjectArray;
	    }
	    else {
	      arrayOfTreeObject = this.treeObjectArrayReconstruct;
	    }
	    for (int i = 0; i < arrayOfTreeObject.length; i++)
	    {
	      if (arrayOfTreeObject[i] == paramTreeObject)
	      {
	        return i;
	      }
	    }
	    return -1;
	  }

	  public TreeObject getById(int paramInt, boolean paramBoolean)
	  {
	    TreeObject localTreeObject = null;
	    TreeObject[] arrayOfTreeObject;
	    if (paramBoolean)
	    {
	      arrayOfTreeObject = this.treeObjectArray;
	    }
	    else {
	      arrayOfTreeObject = this.treeObjectArrayReconstruct;
	    }
	    for (int i = 0; i < arrayOfTreeObject.length; i++) {
	      if (arrayOfTreeObject[i].id == paramInt)
	      {
	        localTreeObject = arrayOfTreeObject[i];
	        break;
	      }
	    }
	    return localTreeObject;
	  }

	  public TreeObject getByName(String paramString, boolean paramBoolean) {
	    TreeObject localTreeObject = null;
	    TreeObject[] arrayOfTreeObject;
	    if (paramBoolean)
	    {
	      arrayOfTreeObject = this.treeObjectArray;
	    }
	    else {
	      arrayOfTreeObject = this.treeObjectArrayReconstruct;
	    }
	    for (int i = 0; i < arrayOfTreeObject.length; i++) {
	      if (arrayOfTreeObject[i].name.equals(paramString))
	      {
	        localTreeObject = arrayOfTreeObject[i];
	        break;
	      }
	    }
	    return localTreeObject;
	  }

	  public TreeObject getRoot(boolean paramBoolean) {
	    if (paramBoolean)
	    {
	      if (this.treeObjectArray == null)
	      {
	        return null;
	      }

	      return this.treeObjectArray[0];
	    }

	    if (this.treeObjectArrayReconstruct == null)
	    {
	      return null;
	    }

	    return this.treeObjectArrayReconstruct[0];
	  }

	  private void searchTreeDepthAndWriteFormatIndent(TreeObject paramTreeObject, int paramInt)
	  {
	    if (paramInt > this.treeDepth) {
	      this.buf.append(".Outline" + String.valueOf(paramInt) + " {");
	      this.buf.append("FONT-SIZE: 9pt; MARGIN-LEFT: ");
	      this.buf.append(String.valueOf(15 + 14 * this.treeDepth));
	      this.buf.append("pt; TEXT-INDENT: -");
	      this.buf.append(String.valueOf(28 + 14 * this.treeDepth));
	      this.buf.append("pt; LINE-HEIGHT: 15pt; FONT-FAMILY: \"宋体\"; TEXT-DECORATION: none} \n ");
	      this.treeDepth = paramInt;
	    }
	    if (paramTreeObject.getChildSize() > 0)
	    {
	      TreeObject[] arrayOfTreeObject = paramTreeObject.getChild();
	      paramInt++;
	      for (int i = 0; i < arrayOfTreeObject.length; i++)
	      {
	        searchTreeDepthAndWriteFormatIndent(arrayOfTreeObject[i], paramInt);
	      }
	    }
	  }

	  private void makeVisible(TreeObject paramTreeObject, int paramInt)
	  {
	    paramInt++;
	    if (paramInt < 2)
	    {
	      paramTreeObject.isVisible = true;
	    }
	    if (paramTreeObject.getChildSize() > 0)
	    {
	      TreeObject[] arrayOfTreeObject = paramTreeObject.getChild();
	      paramInt++;
	      for (int i = 0; i < arrayOfTreeObject.length; i++)
	      {
	        makeVisible(arrayOfTreeObject[i], paramInt);
	      }
	    }
	  }

	  public String beginTrack(TreeObject paramTreeObject) {
	    if (paramTreeObject == null) return null;

	    this.buf = new StringBuffer();

	    this.buf.append("<STYLE type=text/css> \n ");
	    this.treeDepth = 0;
	    searchTreeDepthAndWriteFormatIndent(paramTreeObject, 1);
	    this.buf.append("</STYLE> \n ");

	    this.buf.append("<SCRIPT language=JavaScript> \n <!-- \n function clickHandler() \n {var targetId; \n ");
	    this.buf.append("var srcElement = window.event.srcElement; \n var targetElement; \n ");
	    this.buf.append("if (srcElement.className.substr(0,7) == \"Outline\") \n {if(srcElement.id.substr(0,4)!='Leaf'&& srcElement.id.indexOf(\"Image\")>=0){ \n ");
	    this.buf.append("targetId = srcElement.id.substr(0,srcElement.id.indexOf('Image')) + \"Details\"; \n ");
	    this.buf.append("targetElement = document.all(targetId); \n if (targetElement.style.display == \"none\") { \n ");
	    this.buf.append("targetElement.style.display = \"\"; \n } \n else { \n targetElement.style.display = \"none\"; \n } \n ");
	    this.buf.append("targetId = srcElement.id.substr(0,srcElement.id.indexOf('Image')) + \"Image\"; \n targetElement = document.all(targetId); \n ");
	    this.buf.append("if (targetElement.src.indexOf('" + this.midPlusImage + "') >= 0) {" + " \n " + "targetElement.src = '" + this.midMinusImage + "';" + " \n " + "}" + " \n " + "else {" + " \n ");
	    this.buf.append("targetElement.src = '" + this.midPlusImage + "';" + " \n " + "}" + " \n ");
	    this.buf.append("targetId = srcElement.id.substr(0,srcElement.id.indexOf('Image')) + \"Image1\"; \n ");
	    this.buf.append("targetElement = document.all(targetId); \n ");
	    this.buf.append("if (targetElement.src.indexOf('" + this.nodeOpenImage + "') >= 0) { " + " \n ");
	    this.buf.append("targetElement.src = '" + this.nodeCloseImage + "'; } " + " \n ");
	    this.buf.append("else { targetElement.src = '" + this.nodeOpenImage + "'; } " + " \n ");
	    this.buf.append("} \n } \n } \n document.onclick = clickHandler; \n //-->  \n </SCRIPT> \n ");

	    makeVisible(paramTreeObject, 0);

	    rightChect(paramTreeObject, 0);

	    return this.buf.toString();
	  }

	  private void rightChect(TreeObject paramTreeObject, int paramInt)
	  {
	    if (paramTreeObject.isRight == true)
	    {
	      dispalyTree(paramTreeObject, paramInt);
	    }
	  }

	  private void dispalyTree(TreeObject paramTreeObject, int paramInt)
	  {
	    paramInt++;
	    if (paramTreeObject.type == 1)
	    {
	      this.buf.append("<DIV class=Outline" + paramInt + " id=Node" + paramTreeObject.id + " onmouseover=\"this.style.color='red';this.style.cursor='hand'\" onmouseout=\"this.style.color='black'\">" + " \n ");
	      if (paramTreeObject.isVisible)
	      {
	        this.buf.append("<IMG class=Outline" + paramInt + " id=Node" + paramTreeObject.id + "Image style=\"CURSOR: hand\" src=\"" + this.midMinusImage + "\" width=\"12\" height=\"12\">" + " \n ");
	        this.buf.append("<IMG id=Node" + paramTreeObject.id + "Image1 style=\"CURSOR: hand\" src=\"" + this.nodeOpenImage + "\" width=\"12\" height=\"12\">" + " \n ");
	        linkPre(paramTreeObject.url, paramTreeObject.target);
	        this.buf.append(paramTreeObject.name);
	        linkSuf(paramTreeObject.url);
	        this.buf.append(" \n </DIV> \n ");
	        this.buf.append("<DIV id=Node" + paramTreeObject.id + "Details style=\"DISPLAY: \">" + " \n ");
	      }
	      else {
	        this.buf.append("<IMG class=Outline" + paramInt + " id=Node" + paramTreeObject.id + "Image style=\"CURSOR: hand\" src=\"" + this.midPlusImage + "\" width=\"12\" height=\"12\">" + " \n ");
	        this.buf.append("<IMG id=Node" + paramTreeObject.id + "Image1 style=\"CURSOR: hand\" src=\"" + this.nodeCloseImage + "\" width=\"12\" height=\"12\">" + " \n ");
	        linkPre(paramTreeObject.url, paramTreeObject.target);
	        this.buf.append(paramTreeObject.name);
	        linkSuf(paramTreeObject.url);
	        this.buf.append(" \n </DIV> \n ");
	        this.buf.append("<DIV id=Node" + paramTreeObject.id + "Details style=\"DISPLAY: none\">" + " \n ");
	      }

	      if (paramTreeObject.getChildSize() > 0)
	      {
	        TreeObject[] arrayOfTreeObject = paramTreeObject.getChild();
	        for (int i = 0; i < arrayOfTreeObject.length; i++)
	        {
	          rightChect(arrayOfTreeObject[i], paramInt);
	        }

	      }

	      this.buf.append("</DIV> \n ");
	    }
	    else if (paramTreeObject.type == 2)
	    {
	      this.buf.append("<DIV class=Outline" + paramInt + " onmouseover=\"this.style.color='red';this.style.cursor='hand'\"  onmouseout=\"this.style.color='black'\">" + " \n ");
	      this.buf.append("<IMG class=Outline" + paramInt + " id=Leaf" + paramTreeObject.id + " src=\"" + this.leafImage + "\" width=\"12\" height=\"14\">" + " \n ");
	      linkPre(paramTreeObject.url, paramTreeObject.target);
	      this.buf.append(paramTreeObject.name);
	      linkSuf(paramTreeObject.url);
	      this.buf.append("</DIV> \n ");
	    }
	  }

	  private void linkPre(String paramString1, String paramString2) { if (paramString1 == null) return;
	    if (!paramString1.equals(""))
	    {
	      this.buf.append("<a href=" + paramString1 + " ");
	      if (paramString2 != null)
	      {
	        if (!paramString2.equals(""))
	        {
	          this.buf.append("target=" + paramString2);
	        }
	      }
	      this.buf.append("> ");
	    } }

	  private void linkSuf(String paramString) {
	    if (paramString == null) return;
	    if (!paramString.equals(""))
	    {
	      this.buf.append("</A> \n ");
	    }
	  }

	  public void repaire_for_comuser(String paramString,String userType) {
	    String str = "select module_id,up_module_id,module_name,module_order,MODULE_CONTROL from d_module order by module_id ";
	    setNodeConditon(str, 0, 1, 2, 4, -1, "", -1, 4);
	    str = "select function_id,module_id,function_name,function_order,function_url,function_target,FUNCTION_CONTROL from d_function;";
	    setLeafCondition(str, 0, 1, 3, 4, 4, "", 5, 6);

	    str = "select module_id from D_R_USERMODULE where user_id='" + paramString + "';";
	    setNodeRight(str, 0);
	    str = "select function_id from D_R_USERFUN where user_id='" + paramString + "';";
	    setLeafRight(str, 0);
	    str = "select role_id from d_user_role where user_id='" + paramString + "';";
	    setRoleRight(str, 0);
	    setAllRight(false);
	    makeTree(userType,paramString);
	  }

	  public void repaire_for_manager(String userId, String userOrgName,String userType) {
	    String str = "select module_id,up_module_id,module_name,module_order,concat('./Module/module.jsp?moduleId=',convert(module_id,char)),'rhs' from d_module where MODULE_CONTROL ='1' order by module_id; ";
	    setNodeConditon(str, 0, 1, 3, 5, 2, "", 4, -1);
	    str = "select function_id,module_id,function_name,function_order,concat('./Function/function.jsp?functionId=',convert(function_id,char)),'rhs' from d_function  where FUNCTION_CONTROL ='1' order by function_id;";
	    setLeafCondition(str, 3, 0, 2, 4, 1, "", 5, -1);
	    str = "select module_id from D_R_MODULE_MANAGER where MANAGER_ID='" + userId + "';";
	    setNodeRight(str, 0);
	    str = "select function_id from D_R_FUN_MANAGER where MANAGER_ID='" + userId + "';";
	    setLeafRight(str, 0);
	    setAllRight(true);
	    makeTree(userType,userId);

	    addRootToCurrentTree("系统管理", "http", "url");

	    str = "select ORG_ID,UP_ORG_ID,ORG_NAME,ORG_ORDER,concat('./Dep/dep.jsp?depid=',convert(org_id,char)),'rhs' from d_org order by org_id; ";
	    setNodeConditon(str, 1, 0, 2, 3, 5, "", 4, -1);
	    str = "select role_ID,ORG_ID,role_NAME,role_ORDER,concat('./Role/role.jsp?roleId=',convert(role_id,char)),'rhs' from D_role union select MANAGER_ID,ORG_ID,MANAGER_NAME,MANAGER_ORDER,concat('Manager/manager.jsp?managerId=',convert(manager_id,char)),'rhs' from D_MANAGER union select USER_ID,ORG_ID,USER_NAME,USER_ORDER,concat('User/user.jsp?userId=',convert(user_id,char)),'rhs' from D_USER; ";

	    setLeafCondition(str, 3, 2, 1, 4, 0, "", 5, -1);

	    makeTree(userOrgName,userType,userId);
	  }
	  
	  @Resource
		OrgMapper odao;
		@Resource
		ModuleMapper mdao;
		@Resource
		FunctionMapper fdao;
		public String getOrgName(String userOrgId) {
			return odao.getOrgName(userOrgId);
		}
		public Org getOrg(String userOrgId){
			return odao.getOrg(userOrgId);
		}
		
	  public String[][] getArray1(String userType){
		  List<Map<String, Object>> Maps = null;
		  String[][] array = null;
		  System.out.println("type"+userType);
		  if (userType.equals("1")) {
			Maps = mdao.getManagerMap();
			array = new String[Maps.size()][6];
		} else {
			Maps = mdao.getMap();
			array = new String[Maps.size()][5];
		}
		  select(Maps, array);
			return array;
		}
	  
	  public String[][] getArray2(String userType){
		  List<Map<String, Object>> Maps = null;
		  String[][] array = null;
		  if (userType.equals("1")) {
			Maps = fdao.getManagerMap();
			array = new String[Maps.size()][6];
		  } else {
			Maps = fdao.getMap();
			array = new String[Maps.size()][7];
		  }
			select(Maps, array);
			return array;
	  }
		
	  @Resource
		UserModuleMapper umdao;
	  @Resource
	  MManagerMapper mmdao;
		public String[][] getArray3(String userType,String id){
			List<Map<String, Object>> Maps = null;
			  String[][] array = null;
			  System.out.println("type"+userType);
			  if (userType.equals("1")) {
				Maps = mmdao.getManagerMap(id);
				array = new String[Maps.size()][1];
			} else {
				Maps = umdao.getMap(id);
				array = new String[Maps.size()][1];
			}
			  select(Maps, array);
				return array;
		}
		
		@Resource 
		UserFunMapper ufdao;
		@Resource
		FManagerMapper mfdao;
		public String[][] getArray4(String userType,String id){
			List<Map<String, Object>> Maps = null;
			  String[][] array = null;
			  System.out.println("type"+userType);
			  if (userType.equals("1")) {
				Maps = mfdao.getManagerMap(id);
				array = new String[Maps.size()][1];
			} else {
				Maps = ufdao.getMap(id);
				array = new String[Maps.size()][1];
			}
			  select(Maps, array);
				return array;
		}
		
		@Resource
		UserRoleMapper urdao;
		public String[][] getArray5(String id){
			List<Map<String, Object>> Maps = urdao.getMap(id);
			String[][] array = new String[Maps.size()][1];
			select(Maps, array);
			return array;
		}
		
		public String[][] getArray6(){
			List<Map<String, Object>> Maps = odao.getMap();
			String[][] array = new String[Maps.size()][6];
			select(Maps, array);
			return array;
		}
		

		@Resource
		CommonMapper cdao;
		public String[][] getArray7(){
			List<Map<String, Object>> Maps = cdao.getMap();
			String[][] array = new String[Maps.size()][6];
			select(Maps, array);
			return array;
		}
	  public void select(List<Map<String, Object>> Maps,String[][] array){
		  for (int i = 0; i < Maps.size(); i++) {

				Map<String, Object> map = Maps.get(i);
				Set<String> set =  map.keySet();
				Iterator<String> it = set.iterator();
				for (int j = 0; j < array[i].length ; j++) {
					array[i][j]= String.valueOf(map.get(it.next()));
					System.out.println("  "+array[i][j]);
				}
			}
	  }
		
}
