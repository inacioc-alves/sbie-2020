fun linemean (m,2) = [] | linemean(m,j) = List.nth(head3(m,3), 5) ::linemean(tailcols m, j-1);

fun linemean (m,2) = [] | linemean(m,j) = (sumlist(head3(m,3)) div 9)::linemean(tailcols m, j-1);


fun linemean (m,2) = [] | linemean(m,j) = meio(head3(m,3))::linemean(tailcols m, j-1);
