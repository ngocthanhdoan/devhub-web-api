import{_ as d,c as r,b as t,n as s,w as n,v as l,o as u,d as c,a}from"./index-wipXz1Ph.js";const v={data(){return{currentTab:"tab-1"}}},b={class:"page__center"},p={class:"table-content"},_={class:"box-tab hidden-xs hidden-sm"},h={class:"tab-menu-products"},f={class:"list-tab efch-2 ef-img-t"},m=t("h3",null,"Danh sách dự án",-1),x=t("table",{class:"table-check",border:"0",cellspacing:"0",cellpadding:"0"},[t("thead",null,[t("tr",null,[t("th",null,"ID"),t("th",null,"Tên dự án"),t("th",null,"Ngày tạo"),t("th",null,"Hành động")])]),t("tbody",null,[t("tr",null,[t("td",null,"1"),t("td",null,"Project Alpha"),t("td",null,"2024-08-01"),t("td",null,[t("a",{href:"#"},"Chỉnh sửa"),c(" | "),t("a",{href:"#"},"Xóa")])]),t("tr",null,[t("td",null,"2"),t("td",null,"Project Beta"),t("td",null,"2024-08-05"),t("td",null,[t("a",{href:"#"},"Chỉnh sửa"),c(" | "),t("a",{href:"#"},"Xóa")])])])],-1),w=[m,x],T=a('<h3>Thêm dự án mới</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-100"><div class="field_input"><label>Tên dự án</label></div><div class="field_input"><input class="w-100" type="text" name="project_name" placeholder="Nhập tên dự án"></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Thêm dự án</button></div></div></form>',2),g=[T],j=a('<h3>Chỉnh sửa dự án</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-100"><div class="field_input"><label>Tên dự án</label></div><div class="field_input"><input class="w-100" type="text" name="project_name" value="Project Alpha"></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Lưu thay đổi</button></div></div></form>',2),y=[j],C=a('<h3>Xóa dự án</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-100"><div class="field_input"><label>Chọn dự án để xóa</label></div><div class="field_input"><select class="w-100" name="delete_project"><option value="Project Alpha">Project Alpha</option><option value="Project Beta">Project Beta</option></select></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Xóa dự án</button></div></div></form>',2),P=[C],B=a('<h3>Thiết lập cơ sở dữ liệu cho dự án</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-100"><div class="field_input"><label>Chọn dự án</label></div><div class="field_input"><select class="w-100" name="project_select"><option value="Project Alpha">Project Alpha</option><option value="Project Beta">Project Beta</option></select></div></div></div></div><div class="row_box"><div class="flex_group w-100"><div class="input_group w-50"><div class="field_input"><label>Chọn cơ sở dữ liệu</label></div><div class="field_input"><select class="w-100" name="database_select"><option value="database1">database1</option><option value="database2">database2</option></select></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Lưu cài đặt</button></div></div></form>',2),k=[B],A=a('<h3>Thiết lập quyền truy cập cho dự án</h3><form class="content_box_benefits"><div class="row_box"><div class="flex_group w-100"><div class="input_group w-100"><div class="field_input"><label>Chọn dự án</label></div><div class="field_input"><select class="w-100" name="project_select_permission"><option value="Project Alpha">Project Alpha</option><option value="Project Beta">Project Beta</option></select></div></div></div></div><div class="row_box"><div class="flex_group w-100"><div class="input_group w-50"><div class="field_input"><label>Chọn quyền truy cập</label></div><div class="field_input"><select class="w-100" name="permission_select"><option value="Read">Đọc</option><option value="Write">Ghi</option><option value="Admin">Quản trị</option></select></div></div></div></div><div class="row_box"><div class="field_input"><button type="submit">Cấp quyền</button></div></div></form>',2),N=[A];function X(q,i,D,V,e,L){return u(),r("div",b,[t("div",p,[t("div",_,[t("ul",h,[t("li",{class:s(["menu-tab",{active:e.currentTab==="tab-1"}]),onClick:i[0]||(i[0]=o=>e.currentTab="tab-1")}," Danh sách dự án ",2),t("li",{class:s(["menu-tab",{active:e.currentTab==="tab-2"}]),onClick:i[1]||(i[1]=o=>e.currentTab="tab-2")}," Thêm dự án mới ",2),t("li",{class:s(["menu-tab",{active:e.currentTab==="tab-3"}]),onClick:i[2]||(i[2]=o=>e.currentTab="tab-3")}," Chỉnh sửa dự án ",2),t("li",{class:s(["menu-tab",{active:e.currentTab==="tab-4"}]),onClick:i[3]||(i[3]=o=>e.currentTab="tab-4")}," Xóa dự án ",2),t("li",{class:s(["menu-tab",{active:e.currentTab==="tab-5"}]),onClick:i[4]||(i[4]=o=>e.currentTab="tab-5")}," Thiết lập cơ sở dữ liệu cho dự án ",2),t("li",{class:s(["menu-tab",{active:e.currentTab==="tab-6"}]),onClick:i[5]||(i[5]=o=>e.currentTab="tab-6")}," Thiết lập quyền truy cập cho dự án ",2)])]),t("div",f,[n(t("div",{id:"tab-1",class:s({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-1"})},w,2),[[l,e.currentTab==="tab-1"]]),n(t("div",{id:"tab-2",class:s({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-2"})},g,2),[[l,e.currentTab==="tab-2"]]),n(t("div",{id:"tab-3",class:s({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-3"})},y,2),[[l,e.currentTab==="tab-3"]]),n(t("div",{id:"tab-4",class:s({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-4"})},P,2),[[l,e.currentTab==="tab-4"]]),n(t("div",{id:"tab-5",class:s({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-5"})},k,2),[[l,e.currentTab==="tab-5"]]),n(t("div",{id:"tab-6",class:s({"content-menu-products padding-x-16":!0,active:e.currentTab==="tab-6"})},N,2),[[l,e.currentTab==="tab-6"]])])])])}const z=d(v,[["render",X]]);export{z as default};