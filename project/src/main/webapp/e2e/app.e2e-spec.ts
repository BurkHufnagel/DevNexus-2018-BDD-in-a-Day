import { AppPage } from './app.po';

describe('BDD in a Day client application', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('BDD in a Day: Welcome');
  });
});
