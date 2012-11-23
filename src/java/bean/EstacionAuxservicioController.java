package bean;

import logica.EstacionAuxservicio;
import bean.util.JsfUtil;
import bean.util.PaginationHelper;
import controlador.EstacionAuxservicioFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "estacionAuxservicioController")
@SessionScoped
public class EstacionAuxservicioController implements Serializable {

    private EstacionAuxservicio current;
    private DataModel items = null;
    @EJB
    private controlador.EstacionAuxservicioFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public EstacionAuxservicioController() {
    }

    public EstacionAuxservicio getSelected() {
        if (current == null) {
            current = new EstacionAuxservicio();
            current.setEstacionAuxservicioPK(new logica.EstacionAuxservicioPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private EstacionAuxservicioFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (EstacionAuxservicio) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new EstacionAuxservicio();
        current.setEstacionAuxservicioPK(new logica.EstacionAuxservicioPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Bundle/Bundle").getString("EstacionAuxservicioCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Bundle/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EstacionAuxservicio) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Bundle/Bundle").getString("EstacionAuxservicioUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Bundle/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (EstacionAuxservicio) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Bundle/Bundle").getString("EstacionAuxservicioDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Bundle/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = EstacionAuxservicio.class)
    public static class EstacionAuxservicioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstacionAuxservicioController controller = (EstacionAuxservicioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estacionAuxservicioController");
            return controller.ejbFacade.find(getKey(value));
        }

        logica.EstacionAuxservicioPK getKey(String value) {
            logica.EstacionAuxservicioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new logica.EstacionAuxservicioPK();
            key.setIdentificacionAuxservicio(values[0]);
            key.setNombreEstacion(values[1]);
            key.setFecha(java.sql.Date.valueOf(values[2]));
            return key;
        }

        String getStringKey(logica.EstacionAuxservicioPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getIdentificacionAuxservicio());
            sb.append(SEPARATOR);
            sb.append(value.getNombreEstacion());
            sb.append(SEPARATOR);
            sb.append(value.getFecha());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EstacionAuxservicio) {
                EstacionAuxservicio o = (EstacionAuxservicio) object;
                return getStringKey(o.getEstacionAuxservicioPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EstacionAuxservicioController.class.getName());
            }
        }
    }
}
