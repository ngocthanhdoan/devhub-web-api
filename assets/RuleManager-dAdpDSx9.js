import{_ as o,c as d,b as t,n,w as s,v as l,o as r,d as u,a as c}from"./index-CPtn3M6c.js";const v={data(){return{currentTab:"tab-1"}}},p={class:"page__center"},b={class:"table-content"},_={class:"box-tab hidden-xs hidden-sm"},h={class:"tab-menu-products"},m={class:"list-tab efch-2 ef-img-t"},f=t("h3",null,"Danh sách quyền truy cập",-1),y=t("table",{class:"table-check",border:"0",cellspacing:"0",cellpadding:"0"},[t("thead",null,[t("tr",null,[t("th",null,"ID"),t("th",null,"Tên quyền truy cập"),t("th",null,"Ngày tạo"),t("th",null,"Hành động")])]),t("tbody",null,[t("tr",null,[t("td",null,"1"),t("td",null,"Admin"),t("td",null,"2024-08-01"),t("td",null,[t("a",{href:"#"},"Chỉnh sửa"),u(" | "),t("a",{href:"#"},"Xóa")])]),t("tr",null,[t("td",null,"2"),t("td",null,"Editor"),t("td",null,"2024-08-05"),t("td",null,[t("a",{href:"#"},"Chỉnh sửa"),u(" | "),t("a",{href:"#"},"Xóa")])])])],-1),x=[f,y],T=c('<h3>Thêm quyền truy cập mới</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-100"><div class="field_input"><label>Tên quyền truy cập</label></div><div class="field_input"><input class="w-100" type="text" name="access_name" placeholder="Nhập tên quyền truy cập"></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Thêm quyền truy cập</button></div></div></form>',2),w=[T],g=c('<h3>Chỉnh sửa quyền truy cập</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-100"><div class="field_input"><label>Tên quyền truy cập</label></div><div class="field_input"><input class="w-100" type="text" name="access_name" value="Admin"></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Lưu thay đổi</button></div></div></form>',2),q=[g],C=c('<h3>Xóa quyền truy cập</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-100"><div class="field_input"><label>Chọn quyền truy cập để xóa</label></div><div class="field_input"><select class="w-100" name="delete_access"><option value="Admin">Admin</option><option value="Editor">Editor</option></select></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Xóa quyền truy cập</button></div></div></form>',2),k=[C],N=c('<h3>Cấp phép truy cập</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-50"><div class="field_input"><label>Tài khoản nhà phát triển</label></div><div class="field_input"><select class="w-100" name="developer_account"><option value="dev1">Developer 1</option><option value="dev2">Developer 2</option></select></div></div><div class="input_group w-50"><div class="field_input"><label>Cơ sở dữ liệu</label></div><div class="field_input"><select class="w-100" name="database"><option value="database1">database1</option><option value="database2">database2</option></select></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Cấp phép truy cập</button></div></div></form>',2),D=[N],X=c('<h3>Thiết lập vai trò và quyền hạn</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-50"><div class="field_input"><label>Vai trò</label></div><div class="field_input"><input class="w-100" type="text" name="role_name" placeholder="Nhập vai trò"></div></div><div class="input_group w-50"><div class="field_input"><label>Quyền hạn</label></div><div class="field_input"><input class="w-100" type="text" name="role_permissions" placeholder="Nhập quyền hạn"></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Lưu vai trò và quyền hạn</button></div></div></form>',2),A=[X];function E(V,i,B,L,e,S){return r(),d("div",p,[t("div",b,[t("div",_,[t("ul",h,[t("li",{class:n(["menu-tab",{active:e.currentTab==="tab-1"}]),onClick:i[0]||(i[0]=a=>e.currentTab="tab-1")}," Danh sách quyền truy cập ",2),t("li",{class:n(["menu-tab",{active:e.currentTab==="tab-2"}]),onClick:i[1]||(i[1]=a=>e.currentTab="tab-2")}," Thêm quyền truy cập mới ",2),t("li",{class:n(["menu-tab",{active:e.currentTab==="tab-3"}]),onClick:i[2]||(i[2]=a=>e.currentTab="tab-3")}," Chỉnh sửa quyền truy cập ",2),t("li",{class:n(["menu-tab",{active:e.currentTab==="tab-4"}]),onClick:i[3]||(i[3]=a=>e.currentTab="tab-4")}," Xóa quyền truy cập ",2),t("li",{class:n(["menu-tab",{active:e.currentTab==="tab-5"}]),onClick:i[4]||(i[4]=a=>e.currentTab="tab-5")}," Cấp phép truy cập ",2),t("li",{class:n(["menu-tab",{active:e.currentTab==="tab-6"}]),onClick:i[5]||(i[5]=a=>e.currentTab="tab-6")}," Thiết lập vai trò và quyền hạn ",2)])]),t("div",m,[s(t("div",{id:"tab-1",class:n({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-1"})},x,2),[[l,e.currentTab==="tab-1"]]),s(t("div",{id:"tab-2",class:n({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-2"})},w,2),[[l,e.currentTab==="tab-2"]]),s(t("div",{id:"tab-3",class:n({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-3"})},q,2),[[l,e.currentTab==="tab-3"]]),s(t("div",{id:"tab-4",class:n({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-4"})},k,2),[[l,e.currentTab==="tab-4"]]),s(t("div",{id:"tab-5",class:n({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-5"})},D,2),[[l,e.currentTab==="tab-5"]]),s(t("div",{id:"tab-6",class:n({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-6"})},A,2),[[l,e.currentTab==="tab-6"]])])])])}const H=o(v,[["render",E]]);export{H as default};
