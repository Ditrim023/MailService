export default class MailElement extends HTMLElement {
    constructor(object, settings) {
        super();

        this._object = object;
        this._settings = {
            draggable: true,
            uploadUrl: '',
            uploadRequest: null,
            context: null
        };

        this.attachShadow({mode: 'open'});

        const tmpl = document.createElement('template');
        const style = `
                      <style>
                    .container {
                        display: flex;
                        max-height: 100px;
                        padding: 12px 12px;
                        border-top: 1px solid #e8e9eb;
                        margin-bottom: 5px;
                    }
                    .text, .checkbox{
                        flex: 1;
                        padding-right: 12px;
                    }
      </style>`;

        const container = document.createElement('div');
        container.innerHTML = `
                 <div class="container">
          <div class="checkbox"><input type="checkbox"></div>
          <div class="text">${this._object.fromWho}</div>
          <div class="text">${this._object.theme}</div>
          <div class="text">${this._object.dateCreate}</div>
      </div>
    `;

        tmpl.innerHTML = style;
        tmpl.content.append(container);

        const shadow = this.shadowRoot;
        shadow.append(tmpl.content.cloneNode(true));

        if (object) {
            this.setObject(object);
        }
        if (settings) {
            this.setSettings(settings);
        }

    }

    connectedCallback() {
        // Load additional data when needed
        if (!this._object) {
            const errorMessage = 'Object is missing! Working in a test mode!';
            this._object = {id: '46ce025a', text: 'Test test'};
        }
    }

    get object() {
        return this._object;
    }

    setObject(value) {
        this._object = value;
    }

    getSettings() {
        return this._settings;
    }

    setSettings(settings) {
        this._settings = settings;
    }

}
